package com.example.demoproject.ktscreen

import android.annotation.TargetApi
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.SweepGradient
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.example.demoproject.R
import java.util.*

class CircularSlider : View {
    /**
     * Listener interface used to detect when slider moves around.
     */
    interface OnSliderMovedListener {
        /**
         * This method is invoked when slider moves, providing position of the slider thumb.
         *
         * @param pos Value between 0 and 1 representing the current angle.<br></br>
         * `pos = (Angle - StartingAngle) / (2 * Pi)`
         */
        fun onSliderMoved(pos: Double)
    }

    private var mThumbX = 0
    private var mThumbY = 0
    private var mCircleCenterX = 0
    private var mCircleCenterY = 0
    private var mCircleRadius = 0
    private var mThumbImage: Drawable? = null
    private var mPadding = 0
    private var mThumbSize = 0
    private var mThumbColor = 0
    private var mBorderColor = 0
    private var mBorderGradientColors: IntArray? = null
    private var mBorderThickness = 0
    private var mStartAngle = 0.0
    private var mAngle = mStartAngle
    private var mIsThumbSelected = false
    private val mPaint: Paint = Paint()
    private var mGradientShader: SweepGradient? = null
    private var mListener: OnSliderMovedListener? = null

    constructor(context: Context) : this(context, null) {}
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0) {}
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context, attrs, defStyleAttr)
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
        init(context, attrs, defStyleAttr)
    }

    // common initializer method
    private fun init(context: Context, attrs: AttributeSet?, defStyleAttr: Int) {
        val a: TypedArray =
            context.obtainStyledAttributes(attrs, R.styleable.CircularSlider, defStyleAttr, 0)

        // read all available attributes
        val startAngle: Float =
            a.getFloat(R.styleable.CircularSlider_start_angle, Math.PI.toFloat() / 2)
        val angle: Float = a.getFloat(R.styleable.CircularSlider_angle, Math.PI.toFloat() / 2)
        val thumbSize: Int = a.getDimensionPixelSize(R.styleable.CircularSlider_thumb_size, 50)
        val thumbColor: Int = a.getColor(R.styleable.CircularSlider_thumb_color, Color.GRAY)
        val borderThickness: Int =
            a.getDimensionPixelSize(R.styleable.CircularSlider_border_thickness, 20)
        val borderColor: Int = a.getColor(R.styleable.CircularSlider_border_color, Color.RED)
        val borderGradientColors: String? =
            a.getString(R.styleable.CircularSlider_border_gradient_colors)
        val thumbImage: Drawable? = a.getDrawable(R.styleable.CircularSlider_thumb_image)

        // save those to fields (really, do we need setters here..?)
        setStartAngle(startAngle.toDouble())
        setAngle(angle.toDouble())
        setBorderThickness(borderThickness)
        setBorderColor(borderColor)
        if (borderGradientColors != null) {
            setBorderGradientColors(
                borderGradientColors.split(";".toRegex()).dropLastWhile { it.isEmpty() }
                    .toTypedArray())
        }
        setThumbSize(thumbSize)
        setThumbImage(thumbImage)
        setThumbColor(thumbColor)

        // assign padding - check for version because of RTL layout compatibility
        val padding: Int
        padding = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            val all: Int =
                getPaddingLeft() + getPaddingRight() + getPaddingBottom() + getPaddingTop() + getPaddingEnd() + getPaddingStart()
            all / 6
        } else {
            (getPaddingLeft() + getPaddingRight() + getPaddingBottom() + getPaddingTop()) / 4
        }
        setPadding(padding)
        a.recycle()
    }

    /* ***** Setters ***** */
    fun setStartAngle(startAngle: Double) {
        mStartAngle = startAngle
    }

    fun setAngle(angle: Double) {
        mAngle = angle
    }

    fun setThumbSize(thumbSize: Int) {
        mThumbSize = thumbSize
    }

    fun setBorderThickness(circleBorderThickness: Int) {
        mBorderThickness = circleBorderThickness
    }

    fun setBorderColor(color: Int) {
        mBorderColor = color
    }

    fun setBorderGradientColors(colors: Array<String?>) {
        mBorderGradientColors = IntArray(colors.size)
        for (i in colors.indices) {
            mBorderGradientColors!![i] = Color.parseColor(colors[i])
        }
    }

    fun setBorderGradientColors(colors: IntArray?) {
        if (colors == null) {
            mBorderGradientColors = null
            mGradientShader = null
        } else {
            mBorderGradientColors = Arrays.copyOf(colors, colors.size)
            mGradientShader =
                SweepGradient(mCircleRadius.toFloat(), mCircleRadius.toFloat(), mBorderGradientColors!!, null)
        }
    }

    fun setThumbImage(drawable: Drawable?) {
        mThumbImage = drawable
    }

    fun setThumbColor(color: Int) {
        mThumbColor = color
    }

    fun setPadding(padding: Int) {
        mPadding = padding
    }

    protected override fun onSizeChanged(w: Int, h: Int, oldW: Int, oldH: Int) {
        // use smaller dimension for calculations (depends on parent size)
        val smallerDim = if (w > h) h else w

        // find circle's rectangle points
        val largestCenteredSquareLeft = (w - smallerDim) / 2
        val largestCenteredSquareTop = (h - smallerDim) / 2
        val largestCenteredSquareRight = largestCenteredSquareLeft + smallerDim
        val largestCenteredSquareBottom = largestCenteredSquareTop + smallerDim

        // save circle coordinates and radius in fields
        mCircleCenterX = largestCenteredSquareRight / 2 + (w - largestCenteredSquareRight) / 2
        mCircleCenterY = largestCenteredSquareBottom / 2 + (h - largestCenteredSquareBottom) / 2
        mCircleRadius = smallerDim / 2 - mBorderThickness / 2 - mPadding
        if (mBorderGradientColors != null) {
            mGradientShader = SweepGradient(mCircleRadius.toFloat(), mCircleRadius.toFloat(),
                mBorderGradientColors!!, null)

        }

        // works well for now, should we call something else here?
            super.onSizeChanged(w, h, oldW, oldH)
    }

    protected override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // outer circle (ring)
        mPaint.setColor(mBorderColor)
        mPaint.setStyle(Paint.Style.STROKE)
        mPaint.setStrokeWidth(mBorderThickness.toFloat())
        mPaint.setAntiAlias(true)
        if (mGradientShader != null) {
            mPaint.setShader(mGradientShader)
        }
        canvas.drawCircle(mCircleCenterX.toFloat(), mCircleCenterY.toFloat(),
            mCircleRadius.toFloat(), mPaint)

        // find thumb position
        mThumbX = (mCircleCenterX + mCircleRadius * Math.cos(mAngle)).toInt()
        mThumbY = (mCircleCenterY - mCircleRadius * Math.sin(mAngle)).toInt()
        if (mThumbImage != null) {
            // draw png
            mThumbImage!!.setBounds(
                mThumbX - mThumbSize / 2,
                mThumbY - mThumbSize / 2,
                mThumbX + mThumbSize / 2,
                mThumbY + mThumbSize / 2
            )
            mThumbImage!!.draw(canvas)
        } else {
            // draw colored circle
            mPaint.setColor(mThumbColor)
            mPaint.setStyle(Paint.Style.FILL)
            canvas.drawCircle(mThumbX.toFloat(), mThumbY.toFloat(), mThumbSize.toFloat(), mPaint)
        }
    }

    /**
     * Invoked when slider starts moving or is currently moving. This method calculates and sets position and angle of the thumb.
     *
     * @param touchX Where is the touch identifier now on X axis
     * @param touchY Where is the touch identifier now on Y axis
     */
    private fun updateSliderState(touchX: Int, touchY: Int) {
        val distanceX = touchX - mCircleCenterX
        val distanceY = mCircleCenterY - touchY
        val c = Math.sqrt(Math.pow(distanceX.toDouble(), 2.0) + Math.pow(distanceY.toDouble(), 2.0))
        mAngle = Math.acos(distanceX / c)
        if (distanceY < 0) {
            mAngle = -mAngle
        }
        if (mListener != null) {
            // notify slider moved listener of the new position which should be in [0..1] range
            mListener!!.onSliderMoved((mAngle - mStartAngle) / (2 * Math.PI))
        }
    }

    /**
     * Position setter. This method should be used to manually position the slider thumb.<br></br>
     * Note that counterclockwise [.mStartAngle] is used to determine the initial thumb position.
     *
     * @param pos Value between 0 and 1 used to calculate the angle. `Angle = StartingAngle + pos * 2 * Pi`<br></br>
     * Note that angle will not be updated if the position parameter is not in the valid range [0..1]
     */
    fun setPosition(pos: Double) {
        if (pos >= 0 && pos <= 1) {
            mAngle = mStartAngle + pos * 2 * Math.PI
        }
    }

    /**
     * Saves a new slider moved listener. Set [CircularSlider.OnSliderMovedListener] to `null` to remove it.
     *
     * @param listener Instance of the slider moved listener, or null when removing it
     */
    fun setOnSliderMovedListener(listener: OnSliderMovedListener?) {
        mListener = listener
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(400,400)
    }

//    override fun onTouchEvent(ev: MotionEvent): Boolean {
//        when (ev.getAction()) {
//            MotionEvent.ACTION_DOWN -> {
//
//                // start moving the thumb (this is the first touch)
//                val x = ev.getX() as Int
//                val y = ev.getY() as Int
//
//            }
//            MotionEvent.ACTION_MOVE -> {
//
//                // still moving the thumb (this is not the first touch)
//                if (mIsThumbSelected) {
//                    val x = ev.getX() as Int
//                    val y = ev.getY() as Int
//                    updateSliderState(x, y)
//                }
//            }
//            MotionEvent.ACTION_UP -> {
//
//                // finished moving (this is the last touch)
//                getParent().requestDisallowInterceptTouchEvent(false)
//                mIsThumbSelected = false
//            }
//        }
//
//        // redraw the whole component
//        invalidate()
//        return true
//    }
}