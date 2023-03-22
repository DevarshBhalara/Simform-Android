package com.example.demoproject.kotlinPractice.exception

fun main() {
    val n = intArrayOf(4, 8, 16, 32, 64, 128, 256)
    val d = intArrayOf(2, 0, 4, 4, 0, 8)

    try {
        for (i in n.indices) {
            try {
                println(n[i].toString() + "/" + d[i] + " is " + n[i] / d[i])
            } catch (e: ArithmeticException) {
                println("Can't divide by zero")
            }
        }
    } catch (ex: ArrayIndexOutOfBoundsException) {
        println("No more element")
    }
}