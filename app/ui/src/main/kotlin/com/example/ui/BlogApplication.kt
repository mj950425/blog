package com.example.ui

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(
    scanBasePackages = ["com.example"]
)
class BlogApplication

fun main(args: Array<String>) {
    runApplication<BlogApplication>(*args)
}