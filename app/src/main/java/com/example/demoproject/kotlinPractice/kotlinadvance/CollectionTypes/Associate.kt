package com.example.demoproject.kotlinPractice.CollectionTypes

fun main() {

    Library.books.associate {
        Pair(it.genres.first(), it)
    }.forEach {
        println("${it.key} : ${it.value}")
    }

    println("===")

    Library.books.associateBy {
        it.genres.first()
    }.forEach {
        println("${it.key} : ${it.value}")
    }

    println("===")

    Library.books.associateWith {
        it.genres.first()
    }.forEach {
        println("${it.key} : ${it.value}")
    }

    println("=== zip ===")

    val authors = Library.books.map { it.authors }
    val genres = Library.books.map { it.genres }

    val authorGenre = authors.zip(genres)
    authorGenre.forEach {
        println("${it.first} : ${it.second}")
    }

    val separate = authorGenre.unzip().also {
        println(it.first)
        println(it.second)
    }

}