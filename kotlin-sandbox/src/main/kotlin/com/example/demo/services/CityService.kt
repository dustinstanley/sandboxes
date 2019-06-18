package com.example.demo.services

import com.example.demo.repositories.CityRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CityService @Autowired constructor(val cityRepo: CityRepository) {

    fun getAllCities() : List<CityVO> {
        val cities = cityRepo.findAll()

        return cities.map {
            CityVO(
                id = it.id,
                name = it.name,
                lat = it.lat,
                lon = it.lon
            )
        }
    }
}