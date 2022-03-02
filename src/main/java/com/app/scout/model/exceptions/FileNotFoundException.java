package com.app.scout.model.exceptions;/*
    Created by Labina on 01-Mar-22
*/

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class FileNotFoundException extends RuntimeException {

    String message;

    public FileNotFoundException(String message) {
        super(message);
    }
}
