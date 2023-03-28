package com.example.demoproject.kotlinPractice.CollectionTypes


fun main() {
    val fictionNotFiction: Pair<List<Book>, List<Book>> = Library.books.partition { book: Book ->
        book.genres.all { genre: Genre ->
            genre is Genre.Fiction
        }
    }

    println("=== Fiction === ")
    fictionNotFiction.first.forEach { println(it) }
    println("=== Non Fiction === ")
    fictionNotFiction.second.forEach { println(it) }
}