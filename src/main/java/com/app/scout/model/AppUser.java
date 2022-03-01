package com.app.scout.model;/*
    Created by Labina on 28-Feb-22
*/

import com.app.scout.model.enums.Currency;
import com.app.scout.model.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String surname;
    String username;
    String password;
    String email;
    @ManyToOne
    Country nationality;
    String phoneNumber;
    String imgPath;
    LocalDate DOB;
    @Enumerated(EnumType.STRING)
    Roles role;
    LocalDate createdAt;
    @Enumerated(EnumType.STRING)
    Currency currency;
    boolean expired;
    boolean locked;
    boolean credentialsExpired;
    boolean enabled;
    @ManyToMany
    @JoinTable(name = "saved_properties", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "accommodation_id"))
    List<Accommodation> savedProperties;
    @OneToMany
    List<Traveler> travelers;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority =
                new SimpleGrantedAuthority(role.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !expired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !credentialsExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
