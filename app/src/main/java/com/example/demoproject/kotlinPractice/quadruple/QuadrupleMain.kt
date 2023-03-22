package com.example.demoproject.kotlinPractice.quadruple

import java.io.Serializable

fun <T> Quadruple<T, T, T, T>.toList() = listOf(first, second, third, fourth)

fun main() {
    var a = Quadruple(10, 20, 30, 40)
    println(a.fourth)
}