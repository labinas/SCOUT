package com.app.scout.model;/*
    Created by Labina on 28-Feb-22
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String imgPath;
    LocalDate createdAt;
    LocalDate updatedAt;
    String title;
    String metaTitle;
    String slug;
    String content;
    @OneToMany
    List<BlogComment> comments;
    @OneToMany
    List<BlogLike> likes;
    @ManyToMany
    List<Tag> tags;
}
