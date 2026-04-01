package com.gangatharan.weather_app.service;

import com.gangatharan.weather_app.entity.SearchHistory;
import com.gangatharan.weather_app.entity.User;
import com.gangatharan.weather_app.repository.SearchHistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SearchHistoryServiceImpl implements SearchHistoryService{

      private final SearchHistoryRepository searchHistoryRepository;

    @Override
    public SearchHistory save(SearchHistory history) {
        log.info("Saving search history for city: {}", history.getCity());
        return searchHistoryRepository.save(history);
    }

    @Override
    public List<SearchHistory> getByUser(User user) {
       log.info("Fetching search history for user: {}", user.getUsername());
       return searchHistoryRepository.findByUser(user);
    }
}
