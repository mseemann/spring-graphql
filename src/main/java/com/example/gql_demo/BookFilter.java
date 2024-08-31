package com.example.gql_demo;

import java.util.List;

// inspired by https://github.com/intuit/graphql-filter-java
public record BookFilter(
    StringExpression name,
    List<BookFilter> and,
    List<BookFilter> or,
    List<BookFilter> not
) {
}

