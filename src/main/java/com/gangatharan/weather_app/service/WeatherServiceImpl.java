package com.gangatharan.weather_app.service;

import com.gangatharan.weather_app.config.WeatherApiProperties;
import com.gangatharan.weather_app.dto.WeatherResponseDto;
import com.gangatharan.weather_app.dto.external.OpenWeatherResponse;
import com.gangatharan.weather_app.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService{

    private final WeatherApiProperties properties;
    private final RestTemplate restTemplate;


    @Override
    public WeatherResponseDto getWeatherByCity(String city) {

        String url = UriComponentsBuilder
                .fromUriString(properties.getBaseurl())
                .queryParam("q", city)
                .queryParam("appid", properties.getKey())
                .queryParam("units", "metric")
                .toUriString();

       OpenWeatherResponse response = restTemplate.getForObject(url, OpenWeatherResponse.class);

       if (response == null || response.getMain() == null){
           throw new ResourceNotFoundException("Weather data not found for city: "+city);
       }

       return WeatherResponseDto.builder()
               .city(response.getName())
               .temperature(response.getMain().getTemp())
               .humidity(response.getMain().getHumidity())
               .description(
                       response.getWeather() != null && !response.getWeather().isEmpty()
                             ? response.getWeather().get(0).getDescription()
                             : "No Description")

               .windSpeed(response.getWind() != null
                       ? response.getWind().getSpeed()
                       : 0.0)

               .build();
    }
}
