package com.keroles.Pharmacy.DTO.Mapper;

import com.keroles.Pharmacy.DTO.Model.DrugsDTO;
import com.keroles.Pharmacy.DTO.Model.OrderDTO;
import com.keroles.Pharmacy.Model.Entity.Drugs;
import com.keroles.Pharmacy.Model.Entity.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class OrderMapper {
    public OrderDTO convertEntityToDTO(Order order){
        OrderDTO orderDTO=new OrderDTO();
        orderDTO.setOrderId(order.getOrderId());
        orderDTO.setOrderDatetime(order.getOrderDatetime());
        orderDTO.setOrderLat(order.getOrderLat());
        orderDTO.setOrderLong(order.getOrderLong());
        orderDTO.setPaymentStatus(order.isPaymentStatus());
        orderDTO.setTotalCash(order.getTotalCash());
        orderDTO.setDeliverStatus(order.getDeliverStatus());
        orderDTO.setDeliveryManId(order.getDeliveryMan().getDeliveryManId());
        orderDTO.setDeliveryManName(order.getDeliveryMan().getDeliveryManName());
        orderDTO.setEmployeeId(order.getEmployee().getEmpId());
        orderDTO.setEmployeeName(order.getEmployee().getEmpName());
        orderDTO.setUsersId(order.getUsers().getUserId());
        orderDTO.setUsersName(order.getUsers().getUserName());

        return orderDTO;
    }
    public OrderDTO convertEntityToDTO(Optional<Order> order){
        OrderDTO orderDTO=new OrderDTO();
        orderDTO.setOrderId(order.get().getOrderId());
        orderDTO.setOrderDatetime(order.get().getOrderDatetime());
        orderDTO.setOrderLat(order.get().getOrderLat());
        orderDTO.setOrderLong(order.get().getOrderLong());
        orderDTO.setPaymentStatus(order.get().isPaymentStatus());
        orderDTO.setTotalCash(order.get().getTotalCash());
        orderDTO.setDeliverStatus(order.get().getDeliverStatus());
        orderDTO.setDeliveryManId(order.get().getDeliveryMan().getDeliveryManId());
        orderDTO.setDeliveryManName(order.get().getDeliveryMan().getDeliveryManName());
        orderDTO.setEmployeeId(order.get().getEmployee().getEmpId());
        orderDTO.setEmployeeName(order.get().getEmployee().getEmpName());
        orderDTO.setUsersId(order.get().getUsers().getUserId());
        orderDTO.setUsersName(order.get().getUsers().getUserName());

        return orderDTO;
    }

    public List<OrderDTO> convertEntityListToDTO(List<Order> orders){
        List  ordersDTO= new ArrayList() ;
        for (Order o:orders){
            ordersDTO.add(convertEntityToDTO(o));
        }
        return ordersDTO;
    }

}
