package com.example.gql_demo

import java.util.*

data class Author(val id: String, val firstName: String, val lastName: String) {
    companion object {
        private val AUTHORS: List<Author?> = Arrays.asList(
            Author("author-1", "Joshua", "Bloch"),
            Author("author-2", "Douglas", "Adams"),
            Author("author-3", "Bill", "Bryson")
        )
        
        fun getById(id: String): Author? {
            System.out.printf("Author.getById(%s)%n", id)
            return AUTHORS.stream()
                .filter { author: Author? -> author!!.id == id }
                .findFirst()
                .orElse(null)
        }
    }
}
