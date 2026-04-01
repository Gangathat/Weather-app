package com.gangatharan.weather_app.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WeatherResponseDto {

    private String city;
    private double temperature;
    private String description;
    private int humidity;
    private double windSpeed;
}
