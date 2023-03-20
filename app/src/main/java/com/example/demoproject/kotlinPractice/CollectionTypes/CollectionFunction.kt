package com.example.demoproject.kotlinPractice.CollectionTypes

fun main() {
    val numbers = listOf("one", "two", "three", "four")
    val longerThan3 = numbers.filter { it.length > 3 }
    println(longerThan3)

    val setNumber = setOf(1, 2, 3, 4)
    println(setNumber.map { it * 2 })

    numbers.forEach{
        println(it)
    }
}