package com.gangatharan.weather_app.controller;

import com.gangatharan.weather_app.dto.UserRequestDto;
import com.gangatharan.weather_app.entity.User;
import com.gangatharan.weather_app.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@Valid @RequestBody UserRequestDto dto){

        User user = User.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .build();
        userService.saveUser(user);
    }
}
