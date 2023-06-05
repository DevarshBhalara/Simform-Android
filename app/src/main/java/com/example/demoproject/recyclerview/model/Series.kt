package com.example.demoproject.recyclerview.model

import android.graphics.drawable.Drawable

data class Series(
    val name: String,
    val rating: Float,
    val language: List<String>,
    val seasons: Int,
    val totalEpisodes: Int,
    val gerne: List<String>,
    val image: Drawable?,
    val gerneString: String? = gerne.reduce { first, second -> "$first, $second" },
    val languageString: String = language.reduce{ first, second -> "$first, $second" },
    var isExpanded: Boolean = false,
    var review: List<String> = listOf(),
)