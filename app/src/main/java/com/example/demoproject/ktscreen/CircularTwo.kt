package com.example.demoproject.ktscreen

import android.R.attr.*
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import com.example.demoproject.R
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.sin


class CircularTwo(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private val paint: Paint = Paint()
    private var rectangle: RectF? = null
    private var margin: Float


    private var startSlider = 0f
    private var endSlider = 100f

    private val progressStart = 135f
    private val bgProgressSweep = 270f
    private var actualProgressAngle = 200f

    companion object {
        private const val DEFAULT_PROGRESS = 200f
    }

    init {
        paint.isAntiAlias = true
        paint.color = ContextCompat.getColor(context, R.color.white)
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = dpToPx(7)
        margin = dpToPx(20) // margin should be >= strokeWidth / 2 (otherwise the arc is cut)


        val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.CircularTwo,
            0, 0)
        val progress = typedArray.getFloat(R.styleable.CircularTwo_progressAngle, DEFAULT_PROGRESS)

        actualProgressAngle = (progress * bgProgressSweep) / 100
        Log.e("Angle", actualProgressAngle.toString())

//        actualProgressAngle = if (progress > 270) {
//            270f
//        } else {
//            progress
//        }

        Log.e("Actucal progress", actualProgressAngle.toString())
        Log.e("Default", DEFAULT_PROGRESS.toString())
    }

    @SuppressLint("ResourceAsColor")
    override fun onDraw(canvas: Canvas) {

        super.onDraw(canvas)
        if (rectangle == null) {
            val size = min(width.toFloat() - margin, height.toFloat() - margin)
            rectangle = RectF(margin, margin + 100f ,size, size + 100f)

        }
        //track
        canvas.drawArc(rectangle!!, progressStart, bgProgressSweep, false, paint)
        Log.e("Center", rectangle!!.centerX().toString())

        //progress
        paint.color = ContextCompat.getColor(context, R.color.sliderProgressColor)
        paint.style = Paint.Style.STROKE
        canvas.drawArc(rectangle!!, progressStart, actualProgressAngle, false, paint)


        val sweepAngle = progressStart + actualProgressAngle
        val centerX = rectangle!!.centerX()
        val centerY = rectangle!!.centerY()

        val radius = rectangle!!.height() / 2

        val angle = (sweepAngle % 360) * Math.PI / 180

        val x = centerX + radius * cos(angle)

        Log.e("center x", centerX.toString())
        Log.e("center y", centerY.toString())
        Log.e("center radius", radius.toString())
        Log.e("center angle", angle.toString())
        Log.e("center x", x.toString())


        val y = centerY + radius * sin(angle)

        paint.style = Paint.Style.FILL
        canvas.drawCircle(x.toFloat() , y.toFloat(),30f,paint)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val size = min(measuredWidth, measuredHeight)
        setMeasuredDimension(size,size)
    }
    private fun dpToPx(dp: Int): Float {
        val density: Float = context.resources
            .displayMetrics.density
        return (dp.toFloat() * density)
    }


}