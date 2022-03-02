package com.app.scout.service.impl;/*
    Created by Labina on 28-Feb-22
*/

import com.app.scout.model.Accommodation;
import com.app.scout.repository.BookingRepository;
import com.app.scout.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    @Override
    public int numberOfBookingsByAccommodation(Accommodation accommodation) {
        return bookingRepository.findAllByAccommodation(accommodation).size();
    }
}
