package com.example.demoproject.model

import android.graphics.Color

data class ShoesDetailsModel(

    val shoesName: String,
    val shoesPrice: String,
    val rating: String,
    val description: String,
    val sizes: Array<Int>,
    val colors: Array<String>,
    val appBarTitle: String = "Detail Shoes"
)
