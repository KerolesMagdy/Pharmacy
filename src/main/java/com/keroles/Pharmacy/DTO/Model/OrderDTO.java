package com.keroles.Pharmacy.DTO.Model;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;

@Data
public class OrderDTO extends RepresentationModel<OrderDTO>implements Serializable {
    private int orderId;
    private int deliveryManId;
    private String deliveryManName;
    private int employeeId;
    private String employeeName;
    private int usersId;
    private String usersName;
    private float totalCash;
    private Date orderDatetime;
    private String deliverStatus;
    private boolean paymentStatus;
    private float orderLat;
    private float orderLong;
}
