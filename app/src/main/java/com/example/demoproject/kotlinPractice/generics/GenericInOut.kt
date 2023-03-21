package com.example.demoproject.kotlinPractice.generics

class Cup<out T>
open class B
class A: B()
fun main(args: Array<String>) {

    /** out */
    val b: Cup<B> = Cup<A>()
//    val a: Cup<A> = Cup<B>() // Error

    val anys: Cup<Any> = Cup<Int>()
//    val nothings: Cup<Nothing> = Cup<Int>() // Error

    /** in */
//    val b2: Cup2<B2> = Cup<A2>() //Error
    val a2: Cup2<A2> = Cup2<B2>()

//    val anys2: Cup2<Any> = Cup2<Int>() // Error
    val nothings: Cup2<Nothing> = Cup2<Int>()
}

class Cup2<in T>
open class B2
class A2: B2()
