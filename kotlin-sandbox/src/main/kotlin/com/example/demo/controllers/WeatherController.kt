package com.example.demo.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class WeatherController {

    val counter = AtomicLong()

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String) =
            Greeting(counter.incrementAndGet(), "Hellosdfsdasdsa, $name")

    @GetMapping("/greeting2")
    fun greeting2(@RequestParam(value = "name", defaultValue = "World") name: String) : Greeting =
            Greeting(counter.incrementAndGet(), "aaaaaaaaaaa, $name")

    @GetMapping("/greeting3")
    fun greeting3(@RequestParam(value = "name", defaultValue = "World") name: String) =
            Greeting(counter.incrementAndGet(), "aaaaaaaaaaa, $name")

    @GetMapping("/greeting4")
    fun greeting4(@RequestParam(value = "name", defaultValue = "World") name: String) =
            Greeting(counter.incrementAndGet(), "bbbbbbb, $name")
}