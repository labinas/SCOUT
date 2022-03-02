package com.app.scout.model;/*
    Created by Labina on 28-Feb-22
*/

import com.app.scout.model.enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String roomName;
    int noOfBeds;
    int maxPeople;
    int adultPrice;
    int childPrice;
    int noOfRooms;
    Currency priceCurrency;
    @ManyToMany
    List<Facility> facilities;
}
