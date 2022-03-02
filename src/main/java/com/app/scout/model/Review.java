package com.app.scout.model;/*
    Created by Labina on 28-Feb-22
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    int rating;
    @Column(length = 5000)
    String reviewText;
    boolean recommend;
    boolean visitAgain;
    @ManyToOne
    Accommodation accommodation;
    @ManyToOne
    AppUser user;
}
