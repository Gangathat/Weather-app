package com.gangatharan.weather_app.repository;

import com.gangatharan.weather_app.entity.SearchHistory;
import com.gangatharan.weather_app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SearchHistoryRepository extends JpaRepository<SearchHistory, Long> {

    List<SearchHistory> findByUser (User user);
}
