package com.example.demoproject.kotlinPractice.classAndObect

class TestAccessModifier : Student("Dev", "Bhalara") {

    fun check() {
        super.testProtected()
    }
}