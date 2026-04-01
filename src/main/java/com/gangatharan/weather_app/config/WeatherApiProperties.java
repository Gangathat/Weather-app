package com.gangatharan.weather_app.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(prefix = "weather.api")
@Getter
@Setter
public class WeatherApiProperties {

    private String baseurl;
    private String key;
}
