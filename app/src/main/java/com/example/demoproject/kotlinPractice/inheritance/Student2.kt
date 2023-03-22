package com.example.demoproject.kotlinPractice.inheritance

open class Student2(public var fname: String, var lname: String) {

    open fun printName() {
        println("$fname $lname")
    }
}