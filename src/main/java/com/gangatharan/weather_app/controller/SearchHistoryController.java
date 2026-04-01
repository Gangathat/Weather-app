package com.gangatharan.weather_app.controller;

import com.gangatharan.weather_app.dto.SearchHistoryResponseDto;
import com.gangatharan.weather_app.dto.SearchRequestDto;
import com.gangatharan.weather_app.entity.SearchHistory;
import com.gangatharan.weather_app.entity.User;
import com.gangatharan.weather_app.exception.ResourceNotFoundException;
import com.gangatharan.weather_app.service.SearchHistoryService;
import com.gangatharan.weather_app.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/search")
@RequiredArgsConstructor
public class SearchHistoryController {

    private final UserService userService;
    private final SearchHistoryService searchHistoryService;

    @PostMapping("/{username}")
    public void saveSearch(@PathVariable String username, @Valid @RequestBody SearchRequestDto dto){

        User user = userService.findByUsername(username)
                .orElseThrow(()-> new ResourceNotFoundException("User Not Found"));

        SearchHistory history = SearchHistory.builder()
                .city(dto.getCity())
                .weatherData("DUMMY_DATA")
                .searchTime(LocalDateTime.now())
                .user(user)
                .build();

        searchHistoryService.save(history);
    }

    @GetMapping("/{username}")
    public List<SearchHistoryResponseDto> history(@PathVariable String username){

        User user = userService.findByUsername(username)
                .orElseThrow(()-> new ResourceNotFoundException("UserNotFound"));

        return searchHistoryService.getByUser(user)
                .stream()
                .map(h -> SearchHistoryResponseDto.builder()
                        .city(h.getCity())
                        .weatherData(h.getWeatherData())
                        .searchTime(h.getSearchTime())
                        .build())
                .toList();

    }
}
