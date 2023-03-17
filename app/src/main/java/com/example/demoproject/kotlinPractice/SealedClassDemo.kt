package com.example.demoproject.kotlinPractice

sealed class SealedClassDemoNetflix {
    var count = 10
    enum class Types {
        THRILLER,
        COMEDY,
        CRIME,
        ACTION,
    }

    class Series(val name: String, val seasonCount: Int, val seriesRating: Float, val seriesType: SealedClassDemoNetflix.Types) : SealedClassDemoNetflix() {
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
        fun testMethod(){
            println("Somethings")
        }
    }
}

class DemoOut : SealedClassDemoNetflix() {
    fun testDemoOut() {
        println("Method of DemoOut")
    }
}

fun checkMovieOrSeries(check: SealedClassDemoNetflix) {
    when (check) {
        is SealedClassDemoNetflix.Series -> println("This is Series")
        is SealedClassDemoNetflix.Movie -> println("This is Movie")
        else -> { println("This is nothing!") }
    }
}

fun main() {
    val objSeries = SealedClassDemoNetflix.Series("The Boys", 3,8.6f,SealedClassDemoNetflix.Types.CRIME)
    objSeries.printSeriesDetails()

    val objMovie = SealedClassDemoNetflix.Movie("Dhol",8f)
    objMovie.printMovieDetails()

    val objTest = SealedClassDemoNetflix.Test()
    objTest.testMethod()

    val objTest2 = DemoOut()
    objTest.testMethod()

    checkMovieOrSeries(objSeries)
}