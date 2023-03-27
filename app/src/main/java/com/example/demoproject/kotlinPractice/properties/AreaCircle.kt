package com.example.demoproject.kotlinPractice.properties

import kotlin.math.PI

open class AreaCircle(val radius: Float) {
    val area
        get() = this.radius * this.radius * PI

    //late init var testLateInit: Int = 0 not allowed on primitive type
    lateinit var testLate: String

    open var counter = 0
        set(value) {
            println("set called")
            if(value >= 0)
                field = value
            println("$counter")
        }

    fun printDetails() {
        println("Value of counter is $counter")
    }

    companion object {
        var varInComp = 0
        fun kindOfStatic() {
            println("this is inside companion object")
        }
    }
}