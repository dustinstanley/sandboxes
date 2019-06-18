package com.example.demo.repositories

import org.springframework.data.mongodb.repository.MongoRepository

interface CityRepository : MongoRepository<City, String> {

    fun findByName(name: String) : City
}