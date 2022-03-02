package com.app.scout.model.exceptions;/*
    Created by Labina on 01-Mar-22
*/

public class FileStorageException extends RuntimeException{

    String message;

    public FileStorageException(String message) {
        super(message);
    }
}
