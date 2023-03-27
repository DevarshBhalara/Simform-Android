package com.example.demoproject.kotlinPractice.classAndObect

import com.example.demoproject.AccessModifier.CheckProtected

fun main() {
    val obj = CheckProtected()
    obj.temp
    val objClassForAnonymous = object : Department("Abc", 10) {
        override fun HR() {
            println("This is from override anonymous class")
        }
    }
    objClassForAnonymous.IT()
    objClassForAnonymous.HR()
}