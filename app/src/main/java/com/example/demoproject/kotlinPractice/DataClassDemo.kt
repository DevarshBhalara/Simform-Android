package com.example.demoproject.kotlinPractice

data class SeriesDataClass(var seriesName1: String, var seasonCount: Int, var rating: Float)/*:
    ImplementingInterface("1",DemoInterface.SeriesType.THRILLER,9.0f,"This is just test")*/

fun main() {

    val objElite = SeriesDataClass("Elite",6,8.2f)
    val objLuci = SeriesDataClass("Lucifer",8,8.2f)
    println(objLuci)
    val objCopy2 = objLuci
//    objCopy2.seriesName1 = "Newwwwwwww"
//    changeData(objLuci)
//    println("ObjLuci $objLuci")
    println("Copy $objCopy2")

  //  println(objLuci.seriesReview) // from super class

    println(objElite.toString())

    println()
    val objLuciCopy = objLuci.copy()
    val objLuciCopy2 = objLuci.copy(seriesName1 = "NewLuci")
    println(objLuciCopy)
    println(objLuciCopy2)

    val hash1 = objElite.hashCode()
    val hash2 = objLuci.hashCode()
    val hash3 = objLuciCopy.hashCode()
    println(hash1)
    println(hash2)
    println(hash3)


    println("Rating same ? : ${ objElite.seasonCount == objLuci.seasonCount }")

    println("is Lucifer and elite same ? ${ objElite.equals(objLuci) }")
    println("is Lucifer and Copylucifer same ? ${ objLuciCopy.equals(objLuci) }")
    println("is Lucifer and Copylucifer changed name same ? ${ objLuciCopy2.equals(objLuciCopy) }")
}

//fun changeData(data: SeriesDataClass) {
//    println("Function $data")
//    data.seriesName = "Newwwwww"
//    println("Function $data")
//}