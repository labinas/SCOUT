package com.app.scout.model.exceptions;/*
    Created by Labina on 01-Mar-22
*/

public class FileIsEmptyException extends RuntimeException{

    String message;

    public FileIsEmptyException(String message) {
        super(message);
    }
}
