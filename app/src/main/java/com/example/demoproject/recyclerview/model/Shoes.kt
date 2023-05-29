package com.example.demoproject.recyclerview.model

import android.graphics.drawable.Drawable

data class Shoes(
    val companyName: String,
    val name: String,
    val description: String,
    val price: String,
    val image: Drawable?
)