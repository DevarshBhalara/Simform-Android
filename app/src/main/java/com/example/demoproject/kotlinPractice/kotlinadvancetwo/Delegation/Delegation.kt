package com.example.demoproject.kotlinPractice.Delegation

import kotlin.properties.Delegates

val demoLazy: String by lazy {
    println("Call lazy")
    "Hello"
}

fun main() {
    val bObj = BaseImpl(10)
    Derived(bObj).printMe()

    bObj.str = "Assinging value"
    bObj.str = "New value"

    println(demoLazy)
    println(demoLazy)
    println(demoLazy)

    val userObj = User(
        mapOf(
            "name" to "Abc",
            "age" to 10
        )
    )

    println(userObj.name)
    println(userObj.age)
}


