package com.example.demoproject.kotlinPractice

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

    val userObj = User(mapOf(
        "name" to "Abc",
        "age" to 10
    ))

    println(userObj.name)
    println(userObj.age)
}
interface Base{
    fun printMe()
}

class BaseImpl(val x: Int) : Base {
    var str: String by Delegates.observable("Currently no value"){
        props, old, new ->
        println("$old -> $new")
    }
    override fun printMe() {
        println(x)
    }
}

class Derived(b: Base) : Base by b

//storing in map
class User(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int     by map
}

