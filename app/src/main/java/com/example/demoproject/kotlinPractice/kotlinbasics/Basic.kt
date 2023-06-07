package com.example.demoproject.kotlinPractice

fun main() {
    println("Hello")

    val ans = sum(10, 20)
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

    val str = "Devarsh"

    for (i in str) {
        println(i)
    }

    val rawStringStr = """
        hello 
              my name is 
        Devarsh
    """.trimMargin()

    println(rawStringStr)

    val i = 10
    println("i : $i")

    var str1 = "Devarsh"
    println("$str.length is ${str.length}")

    val value = "h"
    if (value is String) {
        println("$value is a String")
    } else {
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

    val strx = "Devarsh"
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

    var stringTest: String? = "Hello"
    stringTest = null
    val l = if (stringTest != null) println(stringTest.length) else -1
    println(l)

    stringTest.let {
        println(it)
    }

    val l2 = stringTest?.length ?: -1
    println(l2)

    val alice = Person("Alice")
    val sourceList = mutableListOf(alice, Person("Bob"))
    val copyList = sourceList.toList()
    println("${copyList === sourceList}")
    sourceList.add(Person("Charles"))
    alice.name = "Alicia"
    println("First item's name is: ${sourceList[0].name} in source and ${copyList[0].name} in copy")
    println("List size is: ${sourceList.size} in source and ${copyList.size} in copy")
    println("First item's name is: ${sourceList[0].name} in source and ${copyList[0].name} in copy")
    println("${copyList === sourceList}")

    val colors = setOf("red", "brown", "grey")
    val animals = setOf("fox", "bear", "wolf")
    println(colors zip animals)

    val numbersMap = mutableMapOf("one" to 1, "two" to 2, "three" to 3)
    numbersMap["a"] = 10
    println(numbersMap)

    val testList = listOf("a", "b", "c")

    val pair: Pair<String, String> = Pair("abc", "xyz")
    val (value1, value2) = pair
    println(value1)
    println(value2)
    println(pair.second)
    println(pair.first)

//    for ((index, item) in testList.withIndex()) {
//        println("${item.index} : ${i.value}")
//    }
    val objDataClass2 = DataClass2(1, 2, 3, 4, 5, 6, 7, 8, 9,)
    val (aa, bb, cc, dd, ee, ff, gg, hh, ii) = objDataClass2
    println(aa)

    val c1 = Company(10)
    val c2 = Company(20)
    val c3 = Company(30)
    val c4 = Company(20)

    val companies = listOf(c1, c2, c3, c4)
    val uniqueCompanies = companies.toSet()
    println(uniqueCompanies)

}

class Person(var name: String)

fun sum(a: Int, b: Int): Int {
    return a + b
}

data class DataClass2(
    val a1: Int,
    val a2: Int,
    val a3: Int,
    val a5: Int,
    val a6: Int,
    val a7: Int,
    val a8: Int,
    val a9: Int,
    val a10: Int,
)




