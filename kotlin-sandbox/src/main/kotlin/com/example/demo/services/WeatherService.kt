package com.example.demo.services

class WeatherService(val weatherServiceJava: WeatherServiceJava) {

    constructor() : this(WeatherServiceJava()) {

    }
}