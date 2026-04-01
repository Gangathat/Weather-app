package com.gangatharan.weather_app.controller;

import com.gangatharan.weather_app.dto.LoginRequest;
import com.gangatharan.weather_app.entity.User;
import com.gangatharan.weather_app.exception.ResourceNotFoundException;
import com.gangatharan.weather_app.security.JwtUtil;
import com.gangatharan.weather_app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request){
        User user = userService.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException(" Invalid username or password"));

        if(!passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new RuntimeException("Invalid username or password");
        }

        return jwtUtil.generateToken(user.getUsername());
    }
}
