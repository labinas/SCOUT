package com.app.scout.service;/*
    Created by Labina on 28-Feb-22
*/


import com.app.scout.model.AppUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface AppUserService extends UserDetailsService {
    Optional<AppUser> findById(Long id);
    void save(AppUser user);

}
