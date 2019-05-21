package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.repositories.WeatherCondition;
import com.example.demo.repositories.WeatherConditionRepository;

/**
 * The only purpose of this class is to test Kotlin->Java interop and vice-versa
 */
@Component
public class WeatherServiceJava {

    private WeatherConditionRepository weatherConditionRepo;

    @Autowired
    public WeatherServiceJava(WeatherConditionRepository weatherConditionRepo) {
        this.weatherConditionRepo = weatherConditionRepo;
    }

    public List<WeatherCondition> getAllWeatherConditions() {
        return weatherConditionRepo.findAll();
    }
}
