package com.keroles.Pharmacy.Exception.Exceptions;

public class CompanyNotFoundException extends RuntimeException{
    public CompanyNotFoundException(String message) {
        super(message);
    }
}
