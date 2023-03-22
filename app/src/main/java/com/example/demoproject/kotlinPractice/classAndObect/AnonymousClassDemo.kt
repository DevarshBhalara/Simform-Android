package com.example.demoproject.kotlinPractice.classAndObect

fun main() {
    val objClassForAnonymous = object : Department("Abc", 10) {
        override fun HR() {
            println("This is from override anonymous class")
        }
    }
    objClassForAnonymous.IT()
    objClassForAnonymous.HR()
}