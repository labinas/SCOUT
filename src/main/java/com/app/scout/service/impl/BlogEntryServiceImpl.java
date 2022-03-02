package com.app.scout.service.impl;/*
    Created by Labina on 28-Feb-22
*/

import com.app.scout.model.BlogEntry;
import com.app.scout.repository.BlogEntryRepository;
import com.app.scout.service.BlogEntryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BlogEntryServiceImpl implements BlogEntryService {

    private final BlogEntryRepository blogEntryRepository;
    @Override
    public Optional<BlogEntry> findById(Long id) {
        return blogEntryRepository.findById(id);
    }

    @Override
    public void save(BlogEntry blogEntry) {
        blogEntryRepository.save(blogEntry);
    }


}
