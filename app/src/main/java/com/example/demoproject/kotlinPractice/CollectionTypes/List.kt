package com.example.demoproject.kotlinPractice.CollectionTypes

data class Person(var name: String, var age: Int)

fun main() {
    val bob = Person("Bob", 31)
    val people = listOf(Person("Adam", 20), bob, bob)
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
    fun main() {
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
    }

}
