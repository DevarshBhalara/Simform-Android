package com.example.demoproject.kotlinPractice.enumExample


enum class Colors(val code: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF);

    companion object {

        fun getColorSize(): Int {
            return values().size
        }
    }
}