package com.example.demoproject.kotlinPractice.sealedClass

sealed class SealedClassDemoNetflix {
    var count = 10

    enum class Types {
        THRILLER,
        COMEDY,
        CRIME,
        ACTION,
    }

    class Series(
        val name: String,
        val seasonCount: Int,
        val seriesRating: Float,
        val seriesType: SealedClassDemoNetflix.Types
    ) : SealedClassDemoNetflix() {
        fun printSeriesDetails() {
            println(count)
            println("Series name : $name, Total seasons are $seasonCount, ratings are $seriesRating, series type is $seriesType")
        }
    }

    class Movie(val movieName: String, val movieRating: Float) : SealedClassDemoNetflix() {
        fun printMovieDetails() {
            println("Movie name is : $movieName, Movie rating is : $movieRating")
        }
    }

    class Test() {
        fun testMethod() {
            println("Somethings")
        }
    }
}