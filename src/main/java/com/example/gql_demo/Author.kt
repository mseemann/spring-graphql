package com.example.gql_demo;

import java.util.Arrays;
import java.util.List;

public record Author(String id, String firstName, String lastName) {

    private static final List<Author> AUTHORS = Arrays.asList(
        new Author("author-1", "Joshua", "Bloch"),
        new Author("author-2", "Douglas", "Adams"),
        new Author("author-3", "Bill", "Bryson")
    );

    public static Author getById(String id) {
        System.out.printf("Author.getById(%s)%n", id);
        return AUTHORS.stream()
            .filter(author -> author.id().equals(id))
            .findFirst()
            .orElse(null);
    }
}
