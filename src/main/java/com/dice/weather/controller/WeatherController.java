package com.dice.weather.controller;

import com.dice.weather.service.WeatherService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/forecast")
public class WeatherController {
    @Autowired
    public WeatherService weatherService;

    @GetMapping("/{location}/{forecastType}")
    public ResponseEntity<? extends Object> getWeather(@PathVariable String location,
                                                       @PathVariable String forecastType)
    {
        JsonNode forecastDetail = null;
        forecastDetail = weatherService.getWeather(location, forecastType);
        return ResponseEntity.ok(forecastDetail);
    }

    @ExceptionHandler(value = HttpClientErrorException.class)
    public ResponseEntity<Object> exception(HttpClientErrorException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
