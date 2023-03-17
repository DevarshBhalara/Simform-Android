package com.example.demoproject.kotlinPractice

var isEven = SAMFunctionalInterface {
    it % 2 == 0
}

fun main() {
    println("Is 7 even? - ${isEven.accept(7)}")
}