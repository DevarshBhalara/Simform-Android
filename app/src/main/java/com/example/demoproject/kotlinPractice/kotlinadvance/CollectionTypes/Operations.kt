package com.example.demoproject.kotlinPractice.CollectionTypes

fun main() {
    val number = setOf(1, 2, 3)
    println(number.map { it * 2 })
    println(number.mapIndexed { index, value -> index * value })

    println(number.mapNotNull { if (it == 2) null else it * 3 }) //ignore null


    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
    println(numbersMap.mapKeys { it.key.uppercase() })
    println(numbersMap.mapValues { it.value + it.key.length })

    //zip
    val colors = listOf("red", "brown", "grey")
    val animals = listOf("fox", "bear", "wolf")
    println(colors zip animals)
    println(colors.zip(animals) { color, animal -> "The ${animal.replaceFirstChar { it.uppercase() }} is $color" })

    val testSet = setOf("1", "2")
    val twoAnimals = listOf("fox", "bear")
    println(colors zip testSet)

    //unzipping
    val numberPairs = listOf("one" to 1, "two" to 2, "three" to 3, "four" to 4)
    println(numberPairs.unzip())

    //associate  create a map from list
    val numbers = listOf("one", "two", "Three", "four")
    println(numbers.associateWith { it.length })

    println(
        numbers.associateBy(
            keySelector = { it.first().uppercaseChar() },
            valueTransform = { it.length })
    )

    //flat
    val numberSets = listOf(setOf(1, 2, 3), setOf(4, 5, 6), setOf(1, 2))
    println(numberSets.flatten().filter { it < 6 })

    //string representation convert collection to array
    val listString = StringBuffer("The numbers are : ")
    numbers.joinTo(listString)
    println(listString)

    println(numbers.joinToString(separator = " | ", prefix = "start: ", postfix = ": end"))

    //filtering
    val numberPairs2 = listOf("one" to 1, "two" to 2, "three" to 3, "four" to 4, "eleven" to 11)
    val filterdMap =
        numberPairs2.filter { (key, value) -> key.endsWith("e") && value > 0 }
            .sortedBy { println(it); it.first }
            .reversed()
    println("$filterdMap")

    val testTriple = Triple(1, 2, 3)

    val runs = mapOf("ST" to 100, "MSD" to 122, "VK" to 180, "HP" to 77)
    val filteredRuns =
        runs.filter { (key, value) -> value > 100 }.toList().sortedBy { it.second }.reversed()
    println(filteredRuns)
    println("Player who scored highest runs are : ")
    for (i in filteredRuns) {
        println("Player name : ${i.first}, Run : ${i.second} ")
    }

    val numberss = listOf(null, "one", "two", null)
    numberss.filterNotNull().forEach {
        println(it.length)   // length is unavailable for nullable Strings
    }

    val numbers5 = listOf(null, 1, "two", 3.0, "four")
    println("All String elements in upper case:")
    numbers5.filterIsInstance<String>().forEach {
        println(it.uppercase())
    }

    val (high, notHigh) = runs.toList().partition { it.second >= 100 }
    println(high)
    println(notHigh)

    println("Players who have > 100 runs")
    for (i in high) {
        println("Player name ${i.first}  , Runs : ${i.second}")
    }

    println("Players who have < 100 runs")
    for (i in notHigh) {
        println("Player name ${i.first}  , Runs : ${i.second}")
    }

//    var a: Pair<String, Int>
//    a.first = "hello"
//    a.second = 5

    println(numbers.any { it.endsWith("e") })
    println(numbers.none { it.endsWith("a") })
    println(numbers.all { it.endsWith("e") })

    val numbers6 = listOf("one", "two", "three", "four", "five", "six")

    val plusList = numbers6 + "five"
    val minusList = numbers6 - listOf("three", "four")
    println(plusList)
    println(minusList)

    println(numbers6.groupBy { it.first().uppercase() })
    println(numbers6.groupBy(keySelector = { it.first() }, valueTransform = { it.uppercase() }))

    //slice
    println(numbers6.slice(1..4))
    println(numbers6.slice(1..4 step 2))
    println(numbers6.slice(setOf(3, 2, 1)))

    //take and drop
    println(numbers6.take(2))
    println(numbers6.takeLast(3))
    println(numbers6.drop(1))
    println(numbers6.dropLast(2))

    println(numbers6.takeWhile { !it.startsWith("f") })
    println(numbers6.takeLastWhile { it != "three" })

    //chunk
    val exChunk = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    println(exChunk.chunked(2)) //transform list of array List<T>

    //windowed
    println(exChunk.windowed(3))
    println(exChunk.windowed(2, 2))
    println(exChunk.windowed(2, 2, true))

    val numbers7 = listOf("one", "two", "three", "four", "five")
    println(numbers7.zipWithNext())
    println(numbers7.zipWithNext { s1, s2 -> println("$s1 $s2"); s1.length > s2.length })

    //retrieve
    println(numbers7.elementAt(3))
    println(numbers7.elementAtOrNull(9))
    println(numbers7.elementAtOrElse(6) { index -> println("Number at index $index is undefined") })

    println(numbers7.first { it.length > 3 })
    println(numbers7.last { it.startsWith("f") })

    println(numbers7.contains("four"))
    println("zero" in numbers7)

    println(numbers7.containsAll(listOf("four", "two")))
    println(numbers7.containsAll(listOf("one", "zero")))

    println("Sorted by length ascending : ${numbers.sortedWith(compareBy { it.length })}")

    //aggregate
    val numbers8 = listOf(6, 42, 10, 4)

    val nullL: List<Int>?

    println("Count: ${numbers8.count()}")
    println("Max: ${numbers8.maxOrNull()}")
    println("Min: ${numbers8.minOrNull()}")
    println("Average: ${numbers8.average()}")
    println("Sum: ${numbers8.sum()}")

    val min3Remainder = numbers8.minByOrNull { it % 6 }
    println(min3Remainder)

    println(numbers8.sumOf { it * 2 })

    val numbers9 = listOf(5, 2, 10, 4)
    val simpleSum = numbers9.reduce { sum, element -> println("$sum $element"); sum + element }
    println(simpleSum)
    val sumDoubled =
        numbers9.fold(0) { sum, element -> println("$sum $element"); sum + element * 2 }
    println(sumDoubled)

    //foldRight same as fold and reduce but start from last element
    val sumDoubledRight = numbers9.foldRight(0) { element, sum -> sum + element * 2 }
    println(sumDoubledRight)

    val numbers10 = mutableListOf(1, 2, 5, 6)
    numbers10.addAll(arrayOf(7, 8))
    println("$numbers10")

    println(numbers6)
    println(numbers6.subList(2, 4))

    val matrix = listOf(
        listOf(9, 8, 7),
        listOf(5, 3, 2),
        listOf(6, 6, 7)
    )
    val saddlePoints = mutableListOf(
        listOf(0, 0, 0),
        listOf(0, 0, 0),
        listOf(0, 0, 0)
    )
    matrix.forEachIndexed { index, value ->
        value.forEachIndexed { j, number ->
            println("$j $number");
            if (matrix.all { it[j] >= j } && value.all { it <= number }) {
                saddlePoints.add(index, listOf(j))
            }
        }
    }

    val aaa = listOf("a", "b")

    println("$saddlePoints")

    val ex = listOf(
        listOf(1),
        listOf(2, 3, null, 4),
        listOf(null),
        listOf(5)
    )

    println(ex.flatten().filterNotNull())
}
