package com.example.demoproject.kotlinPractice.generics

class GenericExample<T>(input: T) {

    init {
        println("Called with value $input")
    }
}
