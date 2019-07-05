package com.example.demo.controllers

import com.example.demo.services.CityService
import com.example.demo.services.WeatherService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class SimpleController @Autowired constructor(private val weatherService: WeatherService,
                                              private val cityService: CityService) {

    private val counter = AtomicLong()

    @GetMapping("/greeting")
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String) =
            Greeting(counter.incrementAndGet(), "Hello, $name")

    @GetMapping("/weather")
    fun weather() = weatherService.getAllWeatherConditions()

    @GetMapping("/city")
    fun cities() = cityService.getAllCities()
}