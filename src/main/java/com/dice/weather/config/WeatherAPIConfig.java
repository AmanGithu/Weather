package com.dice.weather.config;

import com.dice.weather.service.WeatherService;
import com.dice.weather.service.impl.WeatherServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WeatherAPIConfig {

    @Value("${weatherapi.url}")
    private String url;

    @Value("${weatherapi.key}")
    private String apiKey;

    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public WeatherService weatherService(){
        return new WeatherServiceImpl(restTemplate(), url, apiKey);
    }
}
