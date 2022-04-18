/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keroles.Pharmacy.Exception.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Keroles Magdy
 */
public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message) {
        super(message);
       
    }
    
}
