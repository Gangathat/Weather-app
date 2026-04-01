package com.gangatharan.weather_app.service;

import com.gangatharan.weather_app.entity.SearchHistory;
import com.gangatharan.weather_app.entity.User;

import java.util.List;

public interface SearchHistoryService {

    SearchHistory save(SearchHistory history);

    List<SearchHistory> getByUser(User user);
}
