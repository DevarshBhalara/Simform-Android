package com.example.demoproject.kotlinPractice

fun main() {
    var objClassForAnonymous = object: Department("Abc",10) {
        override fun HR() {
            println("This is from override anonymous class")
        }
    }
    objClassForAnonymous.IT()
    objClassForAnonymous.HR()
}