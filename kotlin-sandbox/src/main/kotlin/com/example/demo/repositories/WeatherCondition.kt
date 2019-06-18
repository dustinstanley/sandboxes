package com.example.demo.repositories

import java.time.Instant
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class WeatherCondition(
    @Id
    val id: Long,

    @Column
    val city: String,

    @Column
    val recordedDtm: Instant,

    @Column(name = "temperature_f")
    val temperatureF: Int
)