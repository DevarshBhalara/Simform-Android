package com.example.demoproject.kotlinPractice.Delegation

interface CalculatorInterface {

    fun add(data: CalculatorVariable): Int
    fun sub(data: CalculatorVariable): Int
}
enum class Operation {
    ADDITION,
    SUBTRACTION
}
data class CalculatorVariable(var a: Int, var b: Int, val operation: Operation)