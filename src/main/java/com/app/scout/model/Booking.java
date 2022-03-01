package com.app.scout.model;/*
    Created by Labina on 28-Feb-22
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    int totalPrice;
    int noOfPeople;
    LocalDate bookedAt;
    LocalDate DateFrom;
    LocalDate DateTo;
    boolean confirmationSent;
    @ManyToOne
    AppUser bookedBy;
    @ManyToOne
    Accommodation accommodation;
    @ManyToOne
    Room room;

}
