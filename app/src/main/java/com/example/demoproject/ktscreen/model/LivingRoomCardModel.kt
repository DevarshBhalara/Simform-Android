package com.example.demoproject.ktscreen.model

import android.graphics.drawable.Drawable

data class LivingRoomCardModel(
    var title: String,
    var status: String,
    var watt: String,
    var isOn: Boolean,
    var isProgressBarVisible: Boolean,
    var isBottomTextVisible: Boolean,
    var image: Drawable? = null,
    var imageResourse: Int = 0,
    var totalProgress: Int = 0,
    var progressInPercent: Float = (totalProgress / 100F),
    var bottomTitle: String? = null,
    var bottomSubTitle: String? = null
)