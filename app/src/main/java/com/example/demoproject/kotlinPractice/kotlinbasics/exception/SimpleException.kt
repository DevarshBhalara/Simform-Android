package com.example.demoproject.kotlinPractice.exception

fun main() {
    try {
        var num = 10 / 0
    } catch (e: ArithmeticException) {
        println("Can't divide by zero")
    }

    val result1 = test(10, 2) //execute try block
    println(result1)
    val result = test(10, 0)   // execute catch block
    println(result)


}

fun test(a: Int, b: Int): Any {
    return try {
        a / b
    } catch (e: Exception) {
        println(e)
        "Divide by zero not allowed"
    }
}