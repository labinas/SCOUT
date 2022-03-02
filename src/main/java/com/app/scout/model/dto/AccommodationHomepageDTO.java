package com.app.scout.model.dto;/*
    Created by Labina on 02-Mar-22
*/

import com.app.scout.model.enums.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccommodationHomepageDTO {
    Long id;
    String name;
    String city;
    String country;
    double userRating;
    Currency currency;
    int price;
    String imageLink;
}
