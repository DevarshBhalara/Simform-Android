package com.example.demoproject.AccessModifier

import com.example.demoproject.kotlinPractice.classAndObect.Student

fun main() {

    //internal class visible within same module
    val a = Student("Devarsh", "Bhalara")
    a.calcAverage()

}

open class CheckProtected : Student("Dev", "Bhalara") {
    internal var temp = 20
    fun check() {
        super.testProtected()
    }
}

class CheckTwo : CheckProtected() {
    fun checktwo() {
        super.testProtected()
    }
}