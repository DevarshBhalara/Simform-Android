package com.example.demoproject.recyclerview.model

import android.graphics.drawable.Drawable

data class Song(
    val songName: String,
    val length: String,
    val albumName: String,
    val releasedYear: Int,
    val isExplicit: Boolean,
    val icon: Drawable? = null
)