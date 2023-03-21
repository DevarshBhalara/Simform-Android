package com.example.demoproject.kotlinPractice.generics

fun main() {
    var objGenericExample = GenericExample<String>("Hello")
    var objGen2 = GenericExample<Int>(10)

    //calling generic function
    genericExample(1, 2, 3, 4, 5,)
    genericExample("a", "b", "c", "d")

    val ints: Array<Int> = arrayOf(1,2,3)
    val anys: Array<Any> = Array<Any>(3) {""}
    for (i in anys.indices) {
        println(anys[i])
    }
    copyArray(
        ints,
        anys
    )

}
class GenericExample <T> (input: T) {

    init {
        println("Called with value $input")
    }
}

fun <T> genericExample(vararg array: T) {
    val list = ArrayList<T>()
    array.forEach {
        list.add(it)
    }
    println(list)
}

fun copyArray(from: Array<out Any>, to: Array<Any>) {
    assert(from.size == to.size)

    for (i in from.indices) {
        to[i] = from[i]
    }

    for (i in to.indices) {
        println(to[i])
    }
}