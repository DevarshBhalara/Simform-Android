package com.example.demoproject.kotlinPractice

import java.io.Serializable

data class Quadruple<out A, out B, out C, out D> (val first: A, val second: B, val third: C, val fourth: D ) : Serializable {

    override fun toString() = "($first, $second, $third, $fourth)"
}
fun <T> Quadruple<T, T, T, T>.toList() = listOf(first, second, third, fourth)

fun main() {
    var a = Quadruple(10, 20, 30, 40)
    println(a.fourth)
}