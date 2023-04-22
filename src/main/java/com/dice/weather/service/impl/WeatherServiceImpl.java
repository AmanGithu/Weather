package com.dice.weather.service.impl;

import com.dice.weather.common.TokenGenerator;
import com.dice.weather.service.WeatherService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class WeatherServiceImpl implements WeatherService {

    private RestTemplate restTemplate;

    private String url;
    private String apiKey;

    public WeatherServiceImpl(RestTemplate restTemplate, String url, String apiKey) {
        this.restTemplate = restTemplate;
        this.url = url;
        this.apiKey = apiKey;
    }


    public JsonNode getWeather(String location, String forecastType) {
        HttpEntity<?> entity = new HttpEntity<>(getHeaders());
        String completeUrl = getCompleteUrl(url, location, forecastType);
        JsonNode forecastDetail = null;
        ResponseEntity<JsonNode> response = restTemplate.exchange(
                completeUrl,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<JsonNode>() {
                }
        );
        forecastDetail = response.getBody();
        return forecastDetail;
    }

    private String getCompleteUrl(String url, String location, String forecastType) {
        StringBuilder sb = new StringBuilder();
        sb.append(url).append("/").append(location).append("/").append(forecastType).append("/");
        return sb.toString();
    }

    public HttpHeaders getHeaders() {
        TokenGenerator tokenGenerator = new TokenGenerator();
        String clintId = tokenGenerator.generateClintId();
        String clintSecret = tokenGenerator.generateClintSecret();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", apiKey);
        headers.set("X-RapidAPI-Host", "forecast9.p.rapidapi.com");
        headers.set("client-id", clintId);
        headers.set("client-secret", clintSecret);
        return headers;
    }
}
