package com.example.demoproject.customview

import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter

@BindingAdapter("layoutWeight")
fun LinearLayout.setLayoutWeight(progress: Double) {
    var layoutParams = layoutParams as LinearLayout.LayoutParams
    layoutParams.weight = progress.toFloat()
    layoutParams = layoutParams
}

@BindingAdapter("layoutWeight")
fun ConstraintLayout.setLayoutWeight(progress: Double) {
    var layoutParams = layoutParams as ConstraintLayout.LayoutParams
    layoutParams.matchConstraintPercentWidth = progress.toFloat()
    layoutParams = layoutParams
}
