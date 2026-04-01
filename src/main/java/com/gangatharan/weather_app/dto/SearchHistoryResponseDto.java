package com.gangatharan.weather_app.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Builder
public class SearchHistoryResponseDto {

    private String city;
    private String weatherData;
    private LocalDateTime searchTime;
}
