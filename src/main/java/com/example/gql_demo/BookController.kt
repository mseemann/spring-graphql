package com.example.gql_demo;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@Controller
public class BookController {

    @QueryMapping
    public Book bookById(@Argument String id) {
        return Book.getById(id);
    }

    @QueryMapping
    public List<Book> searchBook(@Argument BookFilter filter) {
        return Book.byFilter(filter);
    }

    @SubscriptionMapping
    public Flux<Book> bookSubscription() {
        Random random = new Random();
        return Flux.interval(Duration.ZERO, Duration.ofSeconds(1))
            .map(num -> Book.getById("book-" + (random.nextInt(4) + 1)));
    }
//    @SchemaMapping
//    public Author author(Book book) {
//        return Author.getById(book.authorId());
//    }

    @BatchMapping
    Map<Book, Author> author(List<Book> books) {
        System.out.println(books);
        return books.stream()
            .collect(Collectors.toMap(
                book -> book,
                book -> Author.getById(book.authorId())
            ));
    }
}
