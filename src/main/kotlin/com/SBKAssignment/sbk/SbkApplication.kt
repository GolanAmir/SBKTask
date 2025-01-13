package com.assignment.sbk

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class SbkApplication

fun main(args: Array<String>) {
	runApplication<SbkApplication>(*args)
}

@RestController
class SBKWebApp {
    @GetMapping("/hello")
	fun greeting () : String {
		return "Hello Doga"
	}
}