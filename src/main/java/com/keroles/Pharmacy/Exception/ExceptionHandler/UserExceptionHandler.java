/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keroles.Pharmacy.Exception.ExceptionHandler;

import com.keroles.Pharmacy.Constant.ConstantExceptionPhrases;
import com.keroles.Pharmacy.Exception.ExceptionResponseModel.UserExceptionResponseModel;
import com.keroles.Pharmacy.Exception.Exceptions.UserNotFoundException;
import java.util.Date;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author Keroles Magdy
 */
@RestControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
        UserExceptionResponseModel userExceptionResponseModel = new UserExceptionResponseModel(new Date(),HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(userExceptionResponseModel, userExceptionResponseModel.getError());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        
        UserExceptionResponseModel userExceptionResponseModel=new UserExceptionResponseModel(new Date(),HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,ConstantExceptionPhrases.validation_failed+ex.getFieldError().getDefaultMessage() , request.getDescription(false));

        return new ResponseEntity(userExceptionResponseModel, userExceptionResponseModel.getError());
    }
    
    
    
}
