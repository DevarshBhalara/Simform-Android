package com.example.demoproject.recyclerview.model

import android.graphics.drawable.Drawable
import com.example.demoproject.recyclerview.type.ViewType

data class MovieSeries(
    val name: String,
    val rating: Float,
    val language: List<String>,
    val type: ViewType,
    val seasons: Int? = null,
    val totalEpisodes: Int? = null,
    val platform: String? = null,
    val gerne: List<String>? = null,
    val image: Drawable?,
    val gerneString: String? = gerne?.reduce { first, second -> "$first, $second" },
    val releasedYear: Int? = null,
    val time: String?= null,
    val languageString: String = language.reduce{ first, second -> "$first, $second" }
)