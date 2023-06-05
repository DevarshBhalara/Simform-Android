package com.example.demoproject.recyclerview.data

import android.annotation.SuppressLint
import android.content.Context
import com.example.demoproject.R
import com.example.demoproject.recyclerview.model.MovieSeries
import com.example.demoproject.recyclerview.model.Series
import com.example.demoproject.recyclerview.type.ViewType

class SeriesData {
    companion object {
        @SuppressLint("UseCompatLoadingForDrawables")
        fun getAllSeries(context: Context): MutableList<Series> {
            return mutableListOf(
                Series(
                    "Stranger Things",
                    8.2f,
                    listOf("Hindi", "English"),
                    seasons = 4,
                    totalEpisodes = 40,
                    gerne = listOf("Sci-fi", "Horror", "Mystery"),
                    image = context.getDrawable(
                        R.drawable.st
                    )
                ),
                Series(
                    "Farzi",
                    8.5f,
                    listOf("Hindi", "tamil", "Telugu", "Telugu", "Telugu", "Telugu"),
                    seasons = 1,
                    totalEpisodes = 8,
                    gerne = listOf("Crime", "Action"),
                    image = context.getDrawable(R.drawable.farzi2)
                ),
                Series(
                    "Asur",
                    8.2f,
                    listOf("Hindi", "Tamil", "Telugu"),
                    seasons = 1,
                    totalEpisodes = 10,
                    gerne = listOf("Mystery", "Crime"),
                    image = context.getDrawable(
                        R.drawable.asur
                    ),
                    review = listOf(
                        "Really Amazing",
                        "You need to watch this once",
                        "Amazing Thriller"
                    )
                ),
                Series(
                    "Farzi",
                    8.5f,
                    listOf("Hindi", "tamil", "Telugu"),
                    seasons = 1,
                    totalEpisodes = 8,
                    gerne = listOf("Crime", "Action"),
                    image = context.getDrawable(R.drawable.farzi2),
                    review = listOf("Good actings", "Nice story")
                ),
                Series(
                    "Asur",
                    8.2f,
                    listOf("Hindi", "Tamil", "Telugu"),
                    seasons = 1,
                    totalEpisodes = 10,
                    gerne = listOf("Mystery", "Crime"),
                    image = context.getDrawable(
                        R.drawable.asur
                    ),
                    review = listOf(
                        "Really Amazing",
                        "You need to watch this once",
                        "Amazing Thriller"
                    )
                ),
                Series(
                    "Farzi",
                    8.5f,
                    listOf("Hindi", "tamil", "Telugu"),
                    seasons = 1,
                    totalEpisodes = 8,
                    gerne = listOf("Crime", "Action"),
                    image = context.getDrawable(R.drawable.farzi2),
                    review = listOf("Really Amazing", "You need to watch this once")
                ),
                Series(
                    "Stranger Things",
                    8.2f,
                    listOf("Hindi", "English"),
                    seasons = 4,
                    totalEpisodes = 40,
                    gerne = listOf("Sci-fi", "Horror", "Mystery"),
                    image = context.getDrawable(
                        R.drawable.st
                    ),
                    review = listOf("Really Amazing", "great usage of VFX", "Amazing Thriller")

                ),
                Series(
                    "Asur",
                    8.2f,
                    listOf("Hindi", "Tamil", "Telugu"),
                    seasons = 1,
                    totalEpisodes = 10,
                    gerne = listOf("Mystery", "Crime"),
                    image = context.getDrawable(
                        R.drawable.asur
                    ),
                    review = listOf(
                        "Really Amazing",
                        "Can't wait fpr second season",
                        "Amazing Thriller"
                    )
                ),
            )
        }


        @SuppressLint("UseCompatLoadingForDrawables")
        fun addData(context: Context): Series {
            return Series(
                "Stranger Things",
                8.2f,
                listOf("Hindi", "English"),
                seasons = 4,
                totalEpisodes = 40,
                gerne = listOf("Sci-fi", "Horror", "Mystery"),
                image = context.getDrawable(
                    R.drawable.st
                ),
                review = listOf("Really Amazing", "great usage of VFX", "Amazing Thriller")
            )
        }
    }
}