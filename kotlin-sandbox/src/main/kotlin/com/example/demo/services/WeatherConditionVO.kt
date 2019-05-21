package com.example.demo.services

import java.time.Instant

data class WeatherConditionVO(val id: Long, val city: String, val recordedDtm: Instant, val temperatureF: Int) {
}