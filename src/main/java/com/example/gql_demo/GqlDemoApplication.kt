package com.example.gql_demo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class GqlDemoApplication

fun main(args: Array<String>) {
    SpringApplication.run(GqlDemoApplication::class.java, *args)
}

