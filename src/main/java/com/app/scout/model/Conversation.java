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
public class Conversation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    boolean deleted;
    @ManyToOne
    AppUser creator;
    @ManyToOne
    AppUser participant;
    @OneToMany
    List<Message> messages;
}
