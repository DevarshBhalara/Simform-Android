package com.example.demoproject.kotlinPractice

import kotlin.jvm.functions.FunctionN

data class Company(val headCount: Int)

class File(
    var name: String,
    var size: Int,
    var type: Type? = null,
)


enum class Type {
    READ,
    READ_WRITE
}


fun main() {
    val c1 = Company(10)
    val c2 = Company(20)
    val c3 = Company(30)
    val c4 = Company(20)

    val companies = listOf(c1, c2, c3, c4)
    val uniqueCompanies = companies.toSet()
    println(uniqueCompanies)

    val uniq_com = companies.associateBy { it.headCount }.values
    println(uniq_com)

    val files = File("file1", 20)
    val str = files.type ?: "Access Denied"
    println(str)

    files.type?.let { println(it) } ?: println("Access Denied 2")

    when (files.type) {
        null -> println("Access Denied 3")
        else -> println(files.type)
    }

    // lambda expression
    val lambda = { println("Hello this lambda") }
    // higher-order function

    //invoke higher-order function
    higherfunc(
        { println("GeeksforGeeks: A Computer Science portal for Geeks") }
    ) { println("New function") }

    val objFile = File2().apply {
        name = "hello"
        size = 10
        type = Type.READ
    }

    println(test())
    println(test())

    val person = Person4("old", 10).apply {
        name = "Hello"
        age = 10
    }
    println("${person.name} is ")

    val personName = with(person) {
        this.name = "update"
        name
    }
    println(person.name)

    test2(y = 20, x = 10)

    val greeting = Greet { println("Hello greeting!") }
    greeting.greetMethod()


    val greeting2: (String) -> Unit = { println(it) }
    testFunction("Hello", greeting2)

    val greeting3 = { str: String -> println(str) }
    testFunction("Hello", greeting3)
}

class Person4(var name: String, var age: Int)

class File2(
    var name: String = "",
    var size: Int = 0,
    var type: Type? = null,
)

fun higherfunc(lmbd: () -> Unit, function: () -> Unit) {
    lmbd()
    function()
}

fun test2(x: Int, y: Int): Int {
    println("x = $x")
    println("Y = $y")
    return x + y
}

var i = 0

fun test() = (i * i).also { println(i++) }


fun testFunction(param1: String, greet: (String) -> Unit) {
    println(param1)
    greet("Hello")
}

fun interface Greet {
    fun greetMethod()
    fun hello() {
        println("Hello")
    }
}