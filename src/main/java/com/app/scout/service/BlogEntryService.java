package com.app.scout.service;/*
    Created by Labina on 28-Feb-22
*/


import com.app.scout.model.BlogEntry;

import java.util.Optional;

public interface BlogEntryService {
    Optional<BlogEntry> findById(Long id);
    void save(BlogEntry blogEntry);
}
