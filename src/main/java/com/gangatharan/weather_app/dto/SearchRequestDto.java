package com.gangatharan.weather_app.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SearchRequestDto {

    @NotBlank
    private String city;
}
