package com.example.demoproject.kotlinPractice

import kotlin.reflect.typeOf

fun main() {
    println("Hello")

    var ans = sum(10,20)
    println("Hello" + ans)

    val a: Int = 100
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a

    val b: Int = 10000
    val boxedB: Int? = b
    val anotherBoxedB: Int? = b

    println(boxedA === anotherBoxedA)
    println(boxedB === anotherBoxedB)

    val one = 1 // Int
    val threeBillion = 3000000000 // Long
    val oneLong = 1L // Long
    val oneByte: Byte = 1
    val e = 2.7182818284 // Double
    val eFloat = 2.7182818284f // Float, actual value is 2.7182817

    val x = (1 shl 2)
    println(x)

    var str = "Devarsh"

    for (i in str) {
        println(i)
    }

    var rawStringStr = """
        hello 
              my name is 
        Devarsh
    """.trimMargin()

    println(rawStringStr)

    val i = 10
    println("i : $i")

    var str1 = "Devarsh"
    println("$str.length is ${str.length}")

    var value = "h"
    if(value is String) {
        println("$value is a String")
    }else {
        println("Not a string")
    }
    var ch: Char
//
//    println('\uD83D\uDE03')
//
//    var obj: Int? = 10
//    if (obj is String) { // same as !(obj is String)
//        print("Not a String")
//    } else {
//        print(obj.length)
//    }

    //unsafe cast
    var y = 10
//    val x1: String = y as String
//    println(typeOf(x1))
//    println(x1)

    var strx = "Devarsh"
    if (strx is String && strx.length > 0) {
        print(strx.length) // x is automatically cast to String
    }

    //array
    val asc = Array(5) { i -> (i * i).toString() }
    for (i in asc) {
        println(i)
    }

    asc.forEach { println(it) }

    val arr2 = IntArray(5)
    arr2.forEach { println(it) }

    val arr3 = IntArray(5) { 42 }
    arr3.forEach { println(it) }


}

fun sum(a: Int, b: Int): Int {
    return a + b
}