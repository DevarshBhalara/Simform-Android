package com.example.demoproject.kotlinPractice.Delegation

class CalculatorBase : CalculatorInterface {

    override fun add(data: CalculatorVariable): Int {
        println("From CalculatorBase addition")
        return data.a + data.b
    }

    override fun sub(data: CalculatorVariable): Int {
        println("From CalculatorBase subtraction")
        return data.a - data.b
    }
}