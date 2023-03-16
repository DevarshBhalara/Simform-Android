package com.example.demoproject.kotlinPractice

fun main() {
    val objStudent2 = Marks(55, 67, 88, "Devarsh", "Bhalara")
    objStudent2.printName()
    objStudent2.calc()

    objStudent2.isGood().isgood()
}

open class Student2(public var fname: String, var lname: String) {

    open fun printName() {
        println("$fname $lname")
    }
}

//inheritance example
class Marks(var grade1: Int, var grade2: Int, var grade3: Int, fname: String, lname: String): Student2(fname,lname) {

//    var grade1: Int = 0
//    var grade2: Int = 0
//    var grade3: Int = 0

//    constructor(): super("Devarsh", "Bhalara") {
//        println("Inside constructor")
//        this.grade1 = grade1
//        this.grade2 = grade2
//        this.grade3 = grade3
//    }

    override fun printName(){
        super.printName()
        println("Grades are $grade1, $grade2, $grade3")
    }

    var avg: Float = 0f
    fun calc() {
        avg = ((grade1 + grade2 + grade3)/3).toFloat()
        println(avg)
    }

    inner class isGood {
        fun isgood() {
            if (avg > 80f) {
                println("${super@Marks.fname} is Good")
            }else if ( avg <=79 && avg > 50) {
                println("${super@Marks.fname} is Average")
            }else {
                println("is Not good")
            }
        }
    }

}


open class Rectangle {
    open fun draw() {
        println("From base class Rectangle")
    }
}

interface Polygon {
    fun draw()  {
        println("From interface Polygon")
    }
}

class Square() : Rectangle(), Polygon {

    override fun draw() {
        super<Rectangle>.draw() // call to Rectangle.draw()
        super<Polygon>.draw() // call to Polygon.draw()
    }
}