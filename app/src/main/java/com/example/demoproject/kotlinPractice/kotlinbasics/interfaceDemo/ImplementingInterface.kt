package com.example.demoproject.kotlinPractice.interfaceDemo

open class ImplementingInterface(
    override var seriesName: String,
    override var seriesType: DemoInterface.SeriesType,
    override var seriesRating: Float,
    override var seriesReview: String?
) : DemoInterface, DemoInterFace2 {

    override fun setReview(review: String) {
        this.seriesReview = review
    }

    override fun printDetails() {
        super<DemoInterFace2>.printDetails()
        println("Series name is $seriesName, Series type is $seriesType, total rating is $seriesRating and reviews are $seriesReview")
    }


}

fun main() {
    val objSeries =
        ImplementingInterface("Elite", DemoInterface.SeriesType.THRILLER, 8.2f, "must watch once!")
    objSeries.printDetails()

//    objSeries.test() can't access private method
}