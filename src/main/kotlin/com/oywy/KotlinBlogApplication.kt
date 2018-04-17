package com.oywy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.EnableAspectJAutoProxy

@SpringBootApplication
@EnableAspectJAutoProxy
class KotlinBlogApplication

fun main(args: Array<String>) {
    runApplication<KotlinBlogApplication>(*args)
}
