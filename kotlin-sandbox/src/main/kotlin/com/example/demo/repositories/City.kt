package com.example.demo.repositories

import org.springframework.data.annotation.Id

data class City(
        @Id
        val id: String? = null,
        val name: String,
        val lat: Float,
        val lon: Float
)