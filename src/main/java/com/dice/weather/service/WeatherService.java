package com.dice.weather.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;

@Service
public interface WeatherService {
    JsonNode getWeather(String location, String forecastType);
}
