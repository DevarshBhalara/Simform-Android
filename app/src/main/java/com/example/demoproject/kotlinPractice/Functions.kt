package com.example.demoproject.kotlinPractice

class Functions {
}
class Math {
    // user defined infix member function
    infix fun square(n : Int): Int{
        val num = n * n
        return num
    }
}
fun Math.addition(a: Int, b: Int): Int {
    return a + b
}

inline fun myInline(myF: (String) -> Unit) {
    myF("Devarsh")
    println("inline function called")
}
fun main(args: Array<String>) {
    val m = Math()

    // call using infix notation
    val result = m square 3
    println( "The square of a number is: " + result )

    //calling extension method
    var addAns = m.addition(10,20)
    println(addAns)

    myInline { println("Calling") }

    var arryIntList: ArrayList<Int> = arrayListOf<Int>(10, 20)

    val sum: (Int, Int) -> Int = { a: Int, b: Int ->  a + b}
    println(sum(10,20))
}




