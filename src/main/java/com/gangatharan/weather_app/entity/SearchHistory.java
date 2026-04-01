package com.gangatharan.weather_app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Table(name = "search_History")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String city;

    @Column(columnDefinition = "TEXT")
    private String weatherData; //Store JSON String from api

    @Column(nullable = false)
    private LocalDateTime searchTime;

    //Prevent infinite JSON recursion
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;

}
