package com.example.demoproject.kotlinPractice

fun main() {
    //nul safety
    var strTest: String? = "abc"
    strTest = null
    println(strTest)

//    val l = strTest.length throws error
    val l = strTest?.length

    val l2 = if (strTest != null) strTest.length else -1
    println(l2)

    val l3 = strTest ?: -1 //!! converts any value to non-null
    println(l3)

    val v3 = strTest.let { println("inside $it") }
//    println(v3)

    val listWithNulls: List<String?> = listOf("Kotlin", null, "Kotlin2")

    for (item in listWithNulls) {
        item?.let { println(it) } // prints Kotlin and ignores null
    }
}