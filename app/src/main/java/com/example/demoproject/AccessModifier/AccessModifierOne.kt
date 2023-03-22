package com.example.demoproject.AccessModifier

import com.example.demoproject.kotlinPractice.classAndObect.Student

fun main() {
    //internal class visible within same module
    var a = Student("Devarsh","Bhalara")
    a.calcAverage()

}
open class CheckProtected : Student("Dev","Bhalara") {
    fun check() {
        super.testProtected()
    }
}
class CheckTwo : CheckProtected(){
    fun checktwo() {
        super.testProtected()
    }
}