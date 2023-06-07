package com.example.demoproject.kotlinPractice.Delegation

fun main() {
    val objCalculatorBase = CalculatorBase()
    val objEnahanceCalc = EnahanceCalc(objCalculatorBase)

    val addAns = objEnahanceCalc.add(CalculatorVariable(20, 10, Operation.ADDITION))
    println(addAns)

//    val subAns = objEnahanceCalc.sub(CalculatorVariable(20, 10, Operation.SUBTRACTION))

    objEnahanceCalc.performOperation(CalculatorVariable(20, 10, Operation.SUBTRACTION))

}