package com.example.demo.services

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class WeatherService @Autowired constructor(val weatherServiceJava: WeatherServiceJava) {

    fun getAllWeatherConditions() : List<WeatherConditionVO> {
        val wcEntities = weatherServiceJava.allWeatherConditions

        val wcVOs = wcEntities.map {
            WeatherConditionVO(
                    id = it.id,
                    city = it.city,
                    recordedDtm = it.recordedDtm,
                    temperatureF = it.temperatureF
            )
        }

        return wcVOs
    }
}