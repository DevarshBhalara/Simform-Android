package com.example.demoproject.kotlinPractice.interfaceDemo

interface DemoInterface {
    var seriesName: String
    var seriesType: SeriesType
    var seriesRating: Float
    var seriesReview: String?

    enum class SeriesType {
        THRILLER,
        HORROR,
        ACTION,
    }

    fun test2() {
        println("Just random method")
    }

    private fun test() {
        println("Accessing private method")
    }

    fun setReview(review: String)
    fun printDetails()
}

object Demo {

}

fun Demo.test() {

}