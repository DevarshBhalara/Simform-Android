package com.example.demoproject.kotlinPractice.functionAndExtension

inline fun myInlineTwo2(
    myFunctionOne: (String) -> Unit,
    myFunctionTwo: (Int, Int) -> Int
) {

    myFunctionOne("My name is devarsh (from two inline parameter)")
    println("From in line ${myFunctionTwo(10, 20)}")
}

fun main() {
    myInlineTwo2(
        {
            println(it)
        },
        { a: Int, b: Int -> a + b },

        )
}