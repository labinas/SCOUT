package com.app.scout.service;/*
    Created by Labina on 28-Feb-22
*/

import com.app.scout.model.Accommodation;

public interface BookingService {
    int numberOfBookingsByAccommodation(Accommodation accommodation);
}
