package com.example.demoproject.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.demoproject.R

class RoundCustomView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    // Paint object for coloring and styling
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    // Face border width in pixels
    private var borderWidth = 4.0f

    // View size in pixels
    private var size = 320

    companion object {
        private const val DEFAULT_EYE_COLOR = Color.BLACK
    }
    // Some colors for the background
    private var backGroundColor = Color.YELLOW
    private var borderColor = Color.BLACK
    private var eyesColor = DEFAULT_EYE_COLOR
    private  var mouthColor = Color.BLACK


    init {
        paint.isAntiAlias = true
        setUpAttribute(attrs)
    }
    private fun setUpAttribute(attrs: AttributeSet?) {
        val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.RoundCustomView,
            0, 0)
        eyesColor = typedArray.getColor(R.styleable.RoundCustomView_eyesColor, DEFAULT_EYE_COLOR)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawRoundShape(canvas)
        drawEyes(canvas)
        drawMouth(canvas)
    }

    private fun drawRoundShape(canvas: Canvas) {
        paint.color = backGroundColor
        paint.style = Paint.Style.FILL

        val radius = size / 2f

        canvas.drawCircle(size / 2f, size / 2f, radius, paint)

        paint.color = borderColor
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = borderWidth

        canvas.drawCircle(size / 2f, size / 2f, radius - borderWidth / 2f, paint)
    }

    private fun drawEyes(canvas: Canvas) {
        paint.color = eyesColor
        paint.style = Paint.Style.FILL

        val leftEye = RectF(size * 0.32f, size * 0.23f, size * 0.43f, size * 0.50f)
        canvas.drawOval(leftEye, paint)

        val rightEye = RectF(size * 0.57f, size * 0.23f, size * 0.68f, size * 0.50f)
        canvas.drawOval(rightEye, paint)
    }

    private fun drawMouth(canvas: Canvas) {
        val mouthPath = Path()
        mouthPath.moveTo(size * 0.22f, size * 0.7f)
        mouthPath.quadTo(size * 0.50f, size * 0.80f, size * 0.78f, size * 0.70f)
        mouthPath.quadTo(size * 0.50f, size * 0.90f, size * 0.22f, size * 0.70f)
        paint.color = mouthColor
        paint.style = Paint.Style.FILL
        canvas.drawPath(mouthPath, paint)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        size = Math.max(measuredWidth, measuredHeight)
        setMeasuredDimension(size, size)
    }
}