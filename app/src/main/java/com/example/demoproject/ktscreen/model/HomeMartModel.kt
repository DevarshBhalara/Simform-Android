package com.example.demoproject.ktscreen.model

import android.graphics.drawable.Drawable

data class HomeMartModel(
    var image: Drawable?,
    var title: String,
    var subtitle: String,
    var isOn: Boolean = true
)