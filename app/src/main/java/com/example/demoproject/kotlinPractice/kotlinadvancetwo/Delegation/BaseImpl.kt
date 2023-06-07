package com.example.demoproject.kotlinPractice.Delegation

import kotlin.properties.Delegates


class BaseImpl(val x: Int) : Base {
    var str: String by Delegates.observable("Currently no value"){ props, old, new ->
        println("$old -> $new")
    }

    override fun printMe() {
        println(x)
    }
}