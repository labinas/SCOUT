package com.app.scout.repository;/*
    Created by Labina on 01-Mar-22
*/

import com.app.scout.model.AccommodationPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationPhotoRepository extends JpaRepository<AccommodationPhoto, Long> {

}
