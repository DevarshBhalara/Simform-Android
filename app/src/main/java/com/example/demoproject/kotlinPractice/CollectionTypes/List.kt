package com.example.demoproject.kotlinPractice.CollectionTypes

data class Person(var name: String, var age: Int)

fun main() {
    val bob = Person("Bob", 31)
    val people = mutableListOf(Person("Adam", 20), bob, bob)
    val people2 = listOf(Person("Adam", 20), Person("Bob", 31), bob)

    println(people == people2)
    bob.age = 32
    println(people == people2)

    val numbers = mutableListOf(1, 2, 3, 4)
    numbers.add(5)
    numbers.removeAt(1)
    numbers[0] = 0
    numbers.shuffle()
    println(numbers)

    //set
    val num = setOf(1, 3, 5, 7)
    println("Number of elements: ${num.size}")
    if (num.contains(1)) println("1 is in the set")

    val numbersBackwards = setOf(7, 5, 3, 1)
    println("The sets are equal: ${num == numbersBackwards}")

    //map
    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key4" to 1,  "key3" to 3,)

    println("All keys: ${numbersMap.keys}")
    println("All values: ${numbersMap.values}")

    if ("key2" in numbersMap) println("Value by key \"key2\": ${numbersMap["key2"]}")
    if (1 in numbersMap.values) println("The value 1 is in the map")
    if (numbersMap.containsValue(1)) println("The value 1 is in the map") // same as previous

    val anotherMap = mapOf("key2" to 2, "key1" to 1, "key4" to 1, "key3" to 3)

    println("The maps are equal: ${numbersMap == anotherMap}")

    val numbersMap2 = mutableMapOf("one" to 1, "two" to 2)
    numbersMap2.put("three", 3)
    numbersMap2["one"] = 11

    println(numbersMap2)

    //sequence
    val numbersSequence = sequenceOf("four", "three", "two", "one")
    println("$numbersSequence.")

    //without sequence
    val words = "The quick brown fox jumps over the lazy dog".split(" ")
    val lengthsList = words.filter { println("filter: $it"); it.length > 3 }
        .map { println("length: ${it.length}"); it.length }
        .take(4)

    println("Lengths of first 4 words longer than 3 chars:")
    println(lengthsList)

    println("With Sequence")

    val words2 = "The quick brown fox jumps over the lazy dog".split(" ")
    //convert the List to a Sequence
    val wordsSequence = words2.asSequence()

    val lengthsSequence = wordsSequence.filter { println("filter: $it"); it.length > 3 }
        .map { println("length: ${it.length}"); it.length }
        .take(4)

    println("Lengths of first 4 words longer than 3 chars")
    // terminal operation: obtaining the result as a List
    println(lengthsSequence.toList())

}
