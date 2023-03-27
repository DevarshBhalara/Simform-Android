package com.example.demoproject.kotlinPractice.Delegation

class EnahanceCalc(delegate: CalculatorInterface) : CalculatorInterface by delegate {
    private var ans = 0
    fun performOperation(calculatorVariable: CalculatorVariable) {
        println("Called")
        val operation = calculatorVariable.operation

        when (operation) {
            Operation.ADDITION -> {
                ans = add(calculatorVariable)
                println(ans)
            }
            Operation.SUBTRACTION -> {
                ans = sub(calculatorVariable)
                println(ans)
            }
        }

    }
}

