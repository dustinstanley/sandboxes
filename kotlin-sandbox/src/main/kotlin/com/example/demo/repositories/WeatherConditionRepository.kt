package com.example.demo.repositories

import org.springframework.data.jpa.repository.JpaRepository

interface WeatherConditionRepository : JpaRepository<WeatherCondition, Long> {

    fun getAllByCity(city: String)
}