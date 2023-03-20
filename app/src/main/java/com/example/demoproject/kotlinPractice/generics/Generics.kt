package com.example.demoproject.kotlinPractice.generics

fun main() {
    var objGenericExample = GenericExample<String>("Hello")
    var objGen2 = GenericExample<Int>(10)

}
class GenericExample <out T> (input: T) {
    init {
        println("Called with value $input")
    }
}