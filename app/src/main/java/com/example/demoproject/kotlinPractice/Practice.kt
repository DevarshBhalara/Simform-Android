package com.example.demoproject.kotlinPractice

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
    val lambda = { println("GeeksforGeeks: A Computer Science portal for Geeks") }
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

    val person = Person4().apply {
        name = "Hello"
        age = 10
    }

    val personName = with(person){
        name
    }
}

class Person4(var name: String = "", var age: Int = 0)

class File2(
    var name: String = "",
    var size: Int = 0,
    var type: Type? = null,
)


fun higherfunc(lmbd: () -> Unit, function: () -> Unit) {
    lmbd()
    function()
}

var i = 0

fun test() = (i * i).also { println(i++) }