package com.app.scout.repository;/*
    Created by Labina on 28-Feb-22
*/

import com.app.scout.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
}
