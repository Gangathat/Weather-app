package com.gangatharan.weather_app.service;

import com.gangatharan.weather_app.dto.WeatherResponseDto;

public interface WeatherService {

    WeatherResponseDto getWeatherByCity(String city);

}
