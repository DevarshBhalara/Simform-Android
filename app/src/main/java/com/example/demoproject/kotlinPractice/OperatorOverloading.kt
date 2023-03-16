package com.example.demoproject.kotlinPractice

fun main() {

    var objP1 = Point(10,20)
    val objP2 = Point(5,-22)

    val sum = objP1 + objP2
    println("Sum = (${sum.x} , ${sum.y})")

    println("Before : ( ${objP1.x} , ${objP1.y} )")
    --objP1
    println("After : ( ${objP1.x} , ${objP1.y} )")


}
class Point(var x: Int = 0, var y: Int = 10) {

    operator fun plus(obj: Point): Point {
        return Point(x + obj.x, y + obj.y)
    }

    operator fun dec(): Point {
        return Point( --x, --y)
    }

}