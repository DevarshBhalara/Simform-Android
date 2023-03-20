package com.example.demoproject.kotlinPractice.Delegation

import android.view.View.AccessibilityDelegate

class EnahanceCalc (delegate: CalculatorInterface) : CalculatorInterface by delegate{
    var ans = 0
    fun performOperation(calculatorVariable: CalculatorVariable){
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

fun main() {
    val objCalculatorBase = CalculatorBase()
    val objEnahanceCalc = EnahanceCalc(objCalculatorBase)

    val addAns = objEnahanceCalc.add(CalculatorVariable(20, 10, Operation.ADDITION))
    println(addAns)

//    val subAns = objEnahanceCalc.sub(CalculatorVariable(20, 10, Operation.SUBTRACTION))

    objEnahanceCalc.performOperation(CalculatorVariable(20, 10, Operation.SUBTRACTION))

}