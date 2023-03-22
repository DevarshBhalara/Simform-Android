package com.example.demoproject.kotlinPractice.sealedClass

fun checkMovieOrSeries(check: SealedClassDemoNetflix) {
    when (check) {
        is SealedClassDemoNetflix.Series -> println("This is Series")
        is SealedClassDemoNetflix.Movie -> println("This is Movie")
        else -> {
            println("This is nothing!")
        }
    }
}

fun main() {
    val objSeries =
        SealedClassDemoNetflix.Series("The Boys", 3, 8.6f, SealedClassDemoNetflix.Types.CRIME)
    objSeries.printSeriesDetails()

    val objMovie = SealedClassDemoNetflix.Movie("Dhol", 8f)
    objMovie.printMovieDetails()

    val objTest = SealedClassDemoNetflix.Test()
    objTest.testMethod()

    val objTest2 = DemoOutSideSealed()
    objTest.testMethod()

    checkMovieOrSeries(objSeries)
}