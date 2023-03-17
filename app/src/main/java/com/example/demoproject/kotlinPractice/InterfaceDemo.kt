package com.example.demoproject.kotlinPractice

interface DemoInterface {
    var seriesName: String
    var seriesType: SeriesType
    var seriesRating: Float
    var seriesReview: String?

    enum class SeriesType{
        THRILLER,
        HORROR,
        ACTION,
    }

    fun test2(){
        println("Just random method")
    }

    private fun test() {
        println("Accessing private method")
    }
    fun setReview(review: String)
    fun printDetails()
}

interface DemoInterFace2 {
    fun printDetails() {
        println("This is from DemoInterFace2")
    }
}

fun interface SAMFunctionalInterface {
    fun accept(i: Int): Boolean
//    fun test()  can't declare multiple abstract method
//    fun test() {
//        println("This is test method")
//    }
}