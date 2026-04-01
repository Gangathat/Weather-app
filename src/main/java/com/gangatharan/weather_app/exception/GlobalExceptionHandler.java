package com.gangatharan.weather_app.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex){

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorResponse.builder()
                        .message(ex.getMessage())
                        .status(HttpStatus.NOT_FOUND.value())
                        .timeStamp(LocalDateTime.now())
                        .build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex){

        String message = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .findFirst()
                .orElseThrow()
                .getDefaultMessage();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse.builder()
                        .message(message)
                        .status(HttpStatus.BAD_REQUEST.value())
                        .timeStamp(LocalDateTime.now())
                        .build());
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<ErrorResponse> handleHttpClient(HttpClientErrorException ex){
        return ResponseEntity.status(ex.getStatusCode())
                .body(ErrorResponse.builder()
                        .message(ex.getResponseBodyAsString())
                        .status(ex.getStatusCode().value())
                        .timeStamp(LocalDateTime.now())
                        .build()
                );

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneric(Exception ex, HttpServletRequest request){

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorResponse.builder()
                        .message(ex.getMessage())
                        .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .timeStamp(LocalDateTime.now())
                        .build());
    }
}
