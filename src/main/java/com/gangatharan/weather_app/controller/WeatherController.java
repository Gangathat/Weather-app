package com.gangatharan.weather_app.controller;

import com.gangatharan.weather_app.dto.WeatherResponseDto;
import com.gangatharan.weather_app.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/weather")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/{city}")
    public WeatherResponseDto getWeather(@PathVariable String city){
        return weatherService.getWeatherByCity(city);
    }
}
