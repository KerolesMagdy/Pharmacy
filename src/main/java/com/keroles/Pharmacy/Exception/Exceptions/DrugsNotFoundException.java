package com.keroles.Pharmacy.Exception.Exceptions;


public class DrugsNotFoundException extends RuntimeException{
    public DrugsNotFoundException(String message) {
        super(message);
    }
}
