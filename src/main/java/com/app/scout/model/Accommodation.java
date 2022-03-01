package com.app.scout.model;/*
    Created by Labina on 28-Feb-22
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Accommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String address;
    String about;
    double X;
    double Y;
    int NoOfRooms;
    double starRating;
    double userRating;
    boolean entireAccommodation;

    @ManyToMany
    List<AccommodationPhoto> photos;
    @ManyToOne
    AccommodationType type;
    @ManyToMany
    List<Facility> facilities;
    @OneToMany
    List<Room> rooms;
    @ManyToOne
    City city;
    @ManyToMany
    @JoinTable(name = "guests", joinColumns = @JoinColumn(name = "accommodation_id"), inverseJoinColumns = @JoinColumn(name = "guest_id"))
    List<AppUser> guest;

}
