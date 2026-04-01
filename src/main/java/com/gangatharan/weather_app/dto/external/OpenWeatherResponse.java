package com.gangatharan.weather_app.dto.external;

import lombok.Data;

import java.util.List;

@Data
public class OpenWeatherResponse {

    private String name;
    private Main main;
    private Wind wind;
    private List<Weather> weather;

    @Data
    public static class Main{
        private double temp;
        private int humidity;
    }

    @Data
    public static class Wind{
        private double speed;
    }

    @Data
    public static class Weather{
        private String description;
    }
}
