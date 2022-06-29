package com.keroles.Pharmacy.Exception.ExceptionHandler;

import com.keroles.Pharmacy.Constant.ConstantExceptionPhrases;
import com.keroles.Pharmacy.Exception.ExceptionResponseModel.ExceptionResponseModel;
import com.keroles.Pharmacy.Exception.Exceptions.CompanyNotFoundException;
import com.keroles.Pharmacy.Exception.Exceptions.DeliveryManNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

public class DeliveryManExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(DeliveryManNotFoundException.class)
    public final ResponseEntity<Object> handleDeliveryManNotFoundException(DeliveryManNotFoundException ex, WebRequest request) {
        ExceptionResponseModel deliveryManExceptionResponseModel = new ExceptionResponseModel(new Date(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND, ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(deliveryManExceptionResponseModel, deliveryManExceptionResponseModel.getError());
    }
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionResponseModel deliveryManExceptionResponseModel=new ExceptionResponseModel(new Date(),HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST, ConstantExceptionPhrases.validation_failed+ex.getFieldError().getDefaultMessage() , request.getDescription(false));
        return new ResponseEntity(deliveryManExceptionResponseModel, deliveryManExceptionResponseModel.getError());
    }
}