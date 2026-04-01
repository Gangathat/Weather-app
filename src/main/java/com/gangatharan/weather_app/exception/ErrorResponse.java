package com.gangatharan.weather_app.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorResponse {
    private String message;
    private int status;
    private LocalDateTime timeStamp;;
}

