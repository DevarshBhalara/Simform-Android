package com.example.demoproject.ktscreen.model

import android.graphics.drawable.Drawable

data class TempModel(
    val image: Drawable?,
    val title: String,
    var isEnabled: Boolean
)