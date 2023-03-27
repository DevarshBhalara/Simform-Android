package com.example.demoproject.kotlinPractice.operatorOverloading

class Point(var x: Int = 0, var y: Int = 10) {
    operator fun plus(obj: Point): Point {
        return Point(x + obj.x, y + obj.y)
    }

    operator fun dec(): Point {
        return Point(--x, --y)
    }
}