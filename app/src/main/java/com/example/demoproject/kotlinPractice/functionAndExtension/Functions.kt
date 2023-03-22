package com.example.demoproject.kotlinPractice.functionAndExtension

fun Math.addition(a: Int, b: Int): Int {
    return a + b
}

//infix extension
infix fun Math.addTenNum(a: Int): Int {
    println("Infix function extension called")
    return a + 10
}

//inline function
inline fun myInline(myF: () -> Unit) {
    myF()
    println("inline function called")
}

//inline with two arguments
inline fun myInlineTwo( /*crossinline */myFunctionOne: (String) -> Unit,
                                        myFunctionTwo: (Int, Int) -> Int
) {

    myFunctionOne("My name is devarsh (from two inline parameter)")
    println("From in line ${myFunctionTwo(10, 20)}")
}

//generic function
fun <T> genericExample(vararg array: T) {
    val list = ArrayList<T>()
    array.forEach {
        list.add(it)
    }
    println(list)
}

fun main() {
    val m = Math()

    // call using infix notation
    val result = m square 3
    println("The square of a number is: $result")

    //calling extension method
    val addAns = m.addition(10, 20)
    println(addAns)

    //calling infix extension function
    val addTenAns = m addTenNum 20
    println(addTenAns)

    //calling in line function
    myInline { println("Calling") }

    //calling inline with two parameter
    myInlineTwo(
        {
            println(it)
        },
        { a: Int, b: Int -> a + b },

        )

    //calling generic function
    genericExample(1, 2, 3, 4, 5)
    genericExample("a", "b", "c", "d")

//    var arryIntList: ArrayList<Int> = arrayListOf<Int>(10, 20)
//


    //accessing
    val objTemperature = Temperature(32f, 20)
    println("Temperature in Celsius is " + objTemperature.tempInCelsius)

    println("Temperature in Fahrenheit is " + objTemperature.tempInFahrenheit)

    //lambda
    val sum: (Int, Int) -> Int = { a: Int, b: Int -> a + b }
    println(sum(10, 20))

    val sum2 = { x: Int, y: Int -> x + y }
    sum2(19, 29)

    returnFunction()


}

fun returnFunction() {

    fun test(a: Int) {
        println("Nested function called with value of $a")
    }

    return test(10)
}

//fun test2() -> (Int) -> Int {
//    println()
//}


//extension property
//property with getter setter only extended
var Temperature.tempInFahrenheit: Float
    get() = (tempInCelsius * 9) / 5
    set(value) {
        //    println(temp)
        tempInCelsius = (value - 32) * 5 / 9
    }

//fun Temperature.testPrivate () {
//    println(temp)
//}