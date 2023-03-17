package com.example.demoproject.kotlinPractice

import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator

fun main() {

    for(i in Direction.values()) {
        println(i)
    }
    val objColor = Colors.values()
    println(Colors.getColorSize())

    println(Day.MONDAY.nextDay())

}
enum class Direction {
    EAST,
    WEST,
    SOUTH,
    NORTH,
}
enum class Colors(val code: Int){
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF);

    companion object{

        fun getColorSize(): Int {
            return values().size
        }
    }


}
enum class Day {
    MONDAY {
        override fun nextDay() = TUESDAY
    },
    TUESDAY {
        override fun nextDay() = WEDNESDAY
    },
    WEDNESDAY {
        override fun nextDay() = THURSDAY
    },
    THURSDAY {
        override fun nextDay() = FRIDAY
    },
    FRIDAY {
        override fun nextDay() = SATURDAY
    },
    SATURDAY {
        override fun nextDay() = SUNDAY
    },
    SUNDAY {
        override fun nextDay() = MONDAY
    };

    abstract fun nextDay(): Day
}