package com.gangatharan.weather_app.exception;


public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message){
        super(message);
    }

}
