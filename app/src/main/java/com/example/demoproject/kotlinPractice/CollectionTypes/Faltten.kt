package com.example.demoproject.kotlinPractice.CollectionTypes

fun main() {
    val listOfList: List<List<Author>> = Library.books.map { it.authors }.also {
        it.forEach { println(it) }
    }
//    println(listOfList)

    println("===")

    val simpleList: List<Author> = listOfList.flatten().also {
        it.forEach { println(it) }
    }

    println("===")

    val stringOfAuthor: List<String> = listOfList.flatMap { authorList ->
//        val stringAuthor = mutableListOf<String>()
//        authorList.forEach { author -> stringAuthor.add(author.name) }
//        stringAuthor
        authorList.map { it.name }
    }.also { it.forEach { println(it) } }

    println(stringOfAuthor)
//    println(simpleList)
}