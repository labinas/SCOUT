package com.app.scout.repository;/*
    Created by Labina on 28-Feb-22
*/

import com.app.scout.model.AccommodationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationTypeRepository extends JpaRepository<AccommodationType, Long> {
}
