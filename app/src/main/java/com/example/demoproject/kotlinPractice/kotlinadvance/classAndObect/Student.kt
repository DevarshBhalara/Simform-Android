package com.example.demoproject.kotlinPractice.classAndObect

open class Student(var fname: String,var lname: String) {
//    val firstName = "First name is $fname".also (::println)

    var grade1: Int = 0
    var grade2: Int = 0
    var grade3: Int = 0


    protected fun testProtected() {
        println("This is protected method")
    }

    constructor(grade1: Int, grade2: Int, grade3: Int) : this("Dev", "bhalara") {
        println("Inside constructor")
        this.grade1 = grade1
        this.grade2 = grade2
        this.grade3 = grade3
    }

    init {
        println("Initializer block called")
    }

    fun calcAverage() {
        println("${(grade1 + grade2 + grade3) / 3}")
    }

}