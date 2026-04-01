package com.gangatharan.weather_app.service;

import com.gangatharan.weather_app.entity.User;
import com.gangatharan.weather_app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
        log.info("Saving user: {}", user.getUsername());

        //Without this line password save as plain-text that was not good
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
       log.info("Fetching user by Username: {}", username);
       return userRepository.findByUsername(username);
    }
}
