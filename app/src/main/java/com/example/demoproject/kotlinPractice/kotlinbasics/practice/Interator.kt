package com.example.demoproject.kotlinPractice.practice

import com.example.demoproject.kotlinPractice.CollectionTypes.Author
import com.example.demoproject.kotlinPractice.CollectionTypes.Library

fun main() {
    val songs = listOf(
        Song("Sing for the moment", "Eminem", 2002),
        Song("Without me", "Eminem", 2000),
        Song("Save your tears", "The weeknd", 2020),
        Song("Something new", "Wiz khalifa", null),
        Song(null, "Wiz khalifa", null),
    )

    songs.listIterator().also { iteratorSong ->
        while (iteratorSong.hasNext()) {
            println(songs[iteratorSong.nextIndex()].name ?: "NA")
            println(songs[iteratorSong.nextIndex()].singerName ?: "NA")
            println(songs[iteratorSong.nextIndex()].release ?: "NA")
            println()
            iteratorSong.next()
        }
    }

    val author = Library.books.map { book ->
        book.authors
    }.map { author: List<Author> ->
        author.joinToString { it.name }
    }.joinToString(separator = "\n")
    println(author)

    println("===Titles and Authors===")

    val titleAndAuthor = Library.books.map { book ->
        val authors = book.authors.joinToString { it.name }
        "${book.title} by $authors"
    }.joinToString(separator = "\n")
    println(titleAndAuthor)

    println("=== Book + index ===")

    val bookAndIndex = Library.books.mapIndexed { index, book ->
        "$index -> ${book.title}"
    }.joinToString(separator = "\n")
    println(bookAndIndex)


    test(sum = { x, y -> x + y })

    val (name, singerName, release) = getSong()
    println("$name $singerName $release")

}

fun test(sum: (Int, Int) -> Int) {
    println(sum(10, 20))
}

data class Song(
    val name: String?,
    val singerName: String?,
    val release: Int?
)

fun getSong(): Song {
    return Song("Without me", "Eminem", 2002)
}