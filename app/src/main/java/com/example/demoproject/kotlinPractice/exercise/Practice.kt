package com.example.demoproject.kotlinPractice.exercise

class Matrix(matrixAsString: String) {
    val matrix = matrixAsString.split('\n')

    fun display() {
        println(matrix)
    }
}

fun main() {
    val a = Matrix(
        "987 " + "532" + "667" + ""
    )
    println(a.matrix)

    val phrase = """
        hello this
        is test
        is this?
    """.trimIndent()
    val obhMap: Map<String, Int> = mutableMapOf()
    val lowString = phrase.lowercase()

    val listOfString = lowString.split("\\s+".toRegex())
//    listOfString.forEach {
//        if (!obhMap.containsKey(it)) {
//        }
//    }

    val ans = phrase.toLowerCase().split(Regex("\'?[^a-z0-9\']+\'?")).groupingBy { it }.eachCount()

    println(ans.toString())

    val word = "six-year-old"

    val isIsograms = word.split("").groupingBy { it }.eachCount()
    println(isIsograms.mapValues { it.value })




    cipher()
}

fun cipher() {
    val key = 15
    val msg = "This is test"


    val decode = msg.map {
        when {
            it.isUpperCase() -> 'A' + (it - 'a' + key) % 26
            it.isLowerCase() -> 'a' + (it - 'A' + key) % 26
            else -> it
        }
    }.joinToString("")

    println(decode)
}

