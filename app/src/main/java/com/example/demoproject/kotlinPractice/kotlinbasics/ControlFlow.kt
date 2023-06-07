package com.example.demoproject.kotlinPractice

var a = 10
var b = 20
fun main() {


    if (a < b) println("a is min : $a")

    if (a < b) {
        println("a is min : $a")
    } else {
        println("b is min : $b")
    }


    //as a experssion

    val min = if (a < b) a else b
    println("Min is : $min")

    val min2 = if (a < b) {
        println("a is min")
        a
    } else {
        println("b is min")
        b
    }

    println("Value in min2 is $min2")

    val gender = "Male"
    val msg = when (gender) {
        "Male" -> 868
        "Female" -> 68678
        "Other" -> 685
        else -> {
            78
        }
    }

    //when -> if-else if
    val x = 10
    val y = 20
    when {
        x.isEven() -> println("x is odd")
        y.isEven() -> println("y is even")
        else -> println("x+y is odd")
    }

    //For loop
//    for (i in 1.0..5.1) {
//        println(i)
//    }

    for (i in 10 downTo 0 step 2) println(i)

    val array = arrayOf("a", "b", "c")
    for (i in array.indices) {
        println("$i : ${array[i]}")
    }

    for ((index, value) in array.withIndex()) {
        println("at index $index element is $value")
    }

    loop@ for (i in 1..5) {
        for (j in 1..5) {
            if (j == 3)
                continue@loop
            println("J : $j")
        }
        println("i : $i")
    }

    listOf(1, 2, 3, 4, 5).forEach lit@{
        if (it == 3) return@lit
        println("in side for each $it")
    }

    fun test(value: Int = 10, str: String) {
        println("Called")
    }
    test(str = "20")


    fun foo(
        bar: Int = 0,
        baz: Int = 1,
        qux: () -> Unit,
    ) {
        qux()
        println("bar = $bar and baz = $baz")

    }
    foo(1) { println("hello") }
    foo(qux = { println("hello") })
    foo { println("hello") }


    var valOne = 10
    fun testChange(vararg a1: Int) {
        for (i in a1) {
            println(i)
        }
    }
    testChange(10, 20, 20)

}

fun Int.isEven(): Boolean {
    return (this % 2 == 0)
}

private fun Int.isOdd(): Boolean {
    return this % 2 != 0
}
