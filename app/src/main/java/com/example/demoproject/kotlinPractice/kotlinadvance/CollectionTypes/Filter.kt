package com.example.demoproject.kotlinPractice.CollectionTypes

fun main() {
    val multipleAuthors = Library.books.filter { book: Book ->
        book.authors.size > 1
    }.map {
        "${it.title} by ${it.authors.joinToString { it.name }}"
    }.onEach {
        println(it)
    }

    println("===")

    val nonFiction = Library.books.filter {
        it.genres.any { genre: Genre ->
            genre is Genre.NonFiction
        }
    }.map {
        "${it.title} is ${it.genres}}"
    }.also {
        it.forEach {
            println(it)
        }
    }

    println("===")
    val notFinction = Library.books.filter {
        it.genres.none {
            it is Genre.Fiction
        }
    }.map {
        "${it.title} is ${it.genres}}"
    }.onEach {
        println(it)
    }

    println("===")
    val allGenres = Library.books.filter {
        it.genres.all { genre: Genre ->
            genre is Genre.Fiction
        }
    }
//        .map {
//        "${it.title} is ${it.genres}}"
//    }.also {
//        it.forEach {
//            println(it)
//        }
//    }

    println("===")
    val allFictionNotJk = allGenres.filterNot { book: Book ->
        book.authors.any { author: Author ->
            author.name == "J.K. Rowling"
        }
    }.map {
        "${it.title} is ${it.genres}"
    }.also {
        it.forEach {
            println(it)
        }
    }

}

