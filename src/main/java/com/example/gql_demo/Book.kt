package com.example.gql_demo

import java.util.*

data class Book(val id: String, val name: String, val pageCount: Int, @JvmField val authorId: String) {
    companion object {
        private val BOOKS: List<Book?> = Arrays.asList(
            Book("book-1", "Effective Java", 416, "author-1"),
            Book("book-2", "Hitchhiker's Guide to the Galaxy", 208, "author-2"),
            Book("book-3", "Down Under", 436, "author-3"),
            Book("book-4", "Effective Kotlin", 436, "author-1")
        )
        
        fun getById(id: String): Book? {
            return BOOKS.stream()
                .filter { book: Book? -> book!!.id == id }
                .findFirst()
                .orElse(null)
        }

        fun byFilter(filter: BookFilter): List<Book?> {
            println("filter: $filter")
            return BOOKS.stream()
                .filter { book: Book? -> book!!.name.contains(filter.name!!.contains!!) }.toList()
        }
    }
}
