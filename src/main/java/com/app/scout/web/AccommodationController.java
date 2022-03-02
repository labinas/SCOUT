package com.app.scout.web;/*
    Created by Labina on 02-Mar-22
*/

import com.app.scout.model.Accommodation;
import com.app.scout.model.dto.AccommodationHomepageDTO;
import com.app.scout.model.enums.Currency;
import com.app.scout.service.AccommodationService;
import com.app.scout.service.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/accommodation")
@AllArgsConstructor
public class AccommodationController {

    private final AccommodationService accommodationService;
    private final ImageService imageService;

    @GetMapping("/toprated")
    public List<AccommodationHomepageDTO> getTop5Rated(){
        List<Accommodation> topFive = accommodationService.findTop5Rated();

        return topFive.stream().map(a -> new AccommodationHomepageDTO(a.getId(), a.getName(), a.getCity().getName(),
                a.getCity().getCountry().getName(),a.getUserRating(), Currency.MKD, 0, imageService.getPropertyCoverLink(a.getId()))).collect(Collectors.toList());
    }

    @GetMapping("/mostpopular")
    public List<AccommodationHomepageDTO> getTop5Popular(){
        List<Accommodation> topFive = accommodationService.findTop5Popular();

        return topFive.stream().map(a -> new AccommodationHomepageDTO(a.getId(), a.getName(), a.getCity().getName(),
                a.getCity().getCountry().getName(),a.getUserRating(), Currency.MKD, 0, imageService.getPropertyCoverLink(a.getId()))).collect(Collectors.toList());
    }

}
