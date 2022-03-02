package com.app.scout.service;/*
    Created by Labina on 28-Feb-22
*/

import com.app.scout.model.Accommodation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface AccommodationService {
    Optional<Accommodation> findById(Long id);
    void save(Accommodation accommodation);
    List<Accommodation> findTop5Rated();
    List<Accommodation> findTop5Popular();
}
