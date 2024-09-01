package com.example.gql_demo

// inspired by https://github.com/intuit/graphql-filter-java
data class BookFilter(
    val name: StringExpression?,
    val and: List<BookFilter>?,
    val or: List<BookFilter>?,
    val not: List<BookFilter>?
)

