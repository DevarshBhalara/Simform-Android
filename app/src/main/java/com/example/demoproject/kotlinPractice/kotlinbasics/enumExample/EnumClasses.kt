package com.example.demoproject.kotlinPractice.enumExample


fun main() {

    for (i in Direction.values()) {
        println(i)
    }
    val objColor = Colors.values()
    println(Colors.getColorSize())

    println(Day.MONDAY.nextDay())

}



