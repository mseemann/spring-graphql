package com.example.gql_demo

import com.example.gql_demo.Book.Companion.byFilter
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.graphql.data.method.annotation.SchemaMapping
import org.springframework.graphql.data.method.annotation.SubscriptionMapping
import org.springframework.stereotype.Controller
import reactor.core.publisher.Flux
import java.time.Duration
import java.util.*

@Controller
class BookController {
    @QueryMapping
    fun bookById(@Argument id: String): Book? {
        return Book.getById(id)
    }

    @QueryMapping
    fun searchBook(@Argument filter: BookFilter): List<Book?> {
        return byFilter(filter)
    }

    @SubscriptionMapping
    fun bookSubscription(): Flux<Book?> {
        val random = Random()
        return Flux.interval(Duration.ZERO, Duration.ofSeconds(1))
            .mapNotNull { Book.getById("book-" + (random.nextInt(4) + 1)) }
    }

    @SchemaMapping
    fun author(book: Book): Author? {
        return Author.getById(book.authorId);
    }

}
//    @BatchMapping
//    fun author(books: List<Book>): Map<Book?, Author?> {
//        println(books)
//        return books.stream()
//            .collect(Collectors.toMap(
//                { book: Book? -> book },
//                { book: Book -> Author.getById(book.authorId) }
//            ))
//    }
//}
