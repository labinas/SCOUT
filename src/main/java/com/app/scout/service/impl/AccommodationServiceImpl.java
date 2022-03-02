package com.app.scout.service.impl;/*
    Created by Labina on 28-Feb-22
*/

import com.app.scout.model.Accommodation;
import com.app.scout.repository.AccommodationRepository;
import com.app.scout.service.AccommodationService;
import com.app.scout.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccommodationServiceImpl implements AccommodationService {

    private final AccommodationRepository accommodationRepository;
    private final BookingService bookingService;

    @Override
    public Optional<Accommodation> findById(Long id) {
        return accommodationRepository.findById(id);
    }

    @Override
    public void save(Accommodation accommodation) {
        accommodationRepository.save(accommodation);
    }

    @Override
    public List<Accommodation> findTop5Rated() {
        return accommodationRepository.findAll(Sort.by("userRating").descending()).subList(0,5);
    }

    @Override
    public List<Accommodation> findTop5Popular() {
        return accommodationRepository.findAll()
                .stream()
                .sorted(Comparator.comparingInt(bookingService::numberOfBookingsByAccommodation))
                .limit(5)
                .collect(Collectors.toList());
    }
}
