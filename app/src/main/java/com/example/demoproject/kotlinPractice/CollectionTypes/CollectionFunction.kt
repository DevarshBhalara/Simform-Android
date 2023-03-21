package com.example.demoproject.kotlinPractice.CollectionTypes

fun main() {
    val numbers = listOf("one", "two", "three", "four")
    val longerThan3 = numbers.filter { it.length > 3 }
    println(longerThan3)

    val setNumber = setOf(1, 2, 3, 4)
    println(setNumber.map { it * 2 })

    numbers.forEach{
        println(it)
    }

    val number2 = listOf(1, 2, 3, 4)
    val numIterator = number2.iterator()
    while (numIterator.hasNext()) {
        println(numIterator.next())
    }

    val numIterator2 = number2.listIterator()
    while (numIterator2.hasNext()) numIterator2.next()
    println("Printing backward")
    while (numIterator2.hasPrevious()) println("Index : ${numIterator2.previousIndex()} , value : ${numIterator2.previous()}")

    val cars = mutableListOf("BMW", "Volvo", "Toyota", "Audi")
    val carIterator = cars.listIterator()
//    while (carIterator.hasNext()) println(carIterator.next())
    carIterator.next()
    carIterator.next()
    carIterator.remove()
    println("After removing cars : $cars")

    while (carIterator.hasPrevious()) carIterator.previous()

    carIterator.next()
    carIterator.next()
    carIterator.add("RR")
    println("After adding cars : $cars")

    //sequence
    val numbersSequence = sequenceOf("four", "three", "two", "one")
    println("$numbersSequence.")

}