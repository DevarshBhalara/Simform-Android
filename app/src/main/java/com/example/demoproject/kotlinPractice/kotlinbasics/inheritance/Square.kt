package com.example.demoproject.kotlinPractice.inheritance

class Square() : Rectangle(), Polygon {

    override fun draw() {
        super<Rectangle>.draw() // call to Rectangle.draw()
        super<Polygon>.draw() // call to Polygon.draw()
    }
}