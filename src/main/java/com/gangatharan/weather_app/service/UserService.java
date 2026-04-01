package com.gangatharan.weather_app.service;

import com.gangatharan.weather_app.entity.User;

import java.util.Optional;

public interface UserService {

    User saveUser(User user);

    Optional<User> findByUsername(String username);

}
