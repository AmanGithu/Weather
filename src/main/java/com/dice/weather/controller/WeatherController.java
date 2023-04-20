package com.dice.weather.controller;

import com.dice.weather.service.WeatherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/forecast")
public class WeatherController {
    @Autowired
    public WeatherService weatherService;

    @GetMapping("/{location}/{forecastType}")
    public ResponseEntity<? extends Object> getWeather(@PathVariable String location,
                             @PathVariable String forecastType,
                             @RequestHeader("client-id") String clientId,
                             @RequestHeader("client-secret") String clientSecret)
    {
        if(!isValidClient(clientId, clientSecret)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        JsonNode forecastDetail = weatherService.getWeather(location, forecastType);
        return ResponseEntity.ok(forecastDetail);
    }

    private boolean isValidClient(String clientId, String clientSecret) {
        return true;
    }
}
