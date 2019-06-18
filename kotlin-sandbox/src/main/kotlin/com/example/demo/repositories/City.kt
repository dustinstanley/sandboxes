package com.example.demo.repositories

import org.springframework.data.annotation.Id

data class City(
        @Id
        val id: String,

        val name: String,

        val lat: Float,

        val lon: Float
)