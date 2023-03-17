package com.example.demoproject.kotlinPractice

import android.hardware.Camera.Area
import kotlin.math.roundToInt

fun main() {

    val objCircleArea = AreaCircle(2.5f)
    println(objCircleArea.area)

    objCircleArea.printDetails()
    objCircleArea.counter = 10
    objCircleArea.printDetails()

    AreaCircle.kindOfStatic()
    println(AreaCircle.varInComp)
//    println(objCircleArea.testLate)

    var objCheck = CheckingOverride(10f)
    println(objCheck.counter)
}
class CheckingOverride(r: Float): AreaCircle(r) {
    override var counter: Int = 10

}