package com.keroles.Pharmacy.DTO.Mapper;

import com.keroles.Pharmacy.DTO.Model.OrderDTO;
import com.keroles.Pharmacy.DTO.Model.OrderInfoDTO;
import com.keroles.Pharmacy.Model.Entity.Order;
import com.keroles.Pharmacy.Model.Entity.OrderInfo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class OrderInfoMapper {
    public OrderInfoDTO convertEntityToDTO(OrderInfo orderInfo){
        OrderInfoDTO orderInfoDTO=new OrderInfoDTO();
        orderInfoDTO.setOrderInfoId(orderInfo.getOrderInfoId());
        orderInfoDTO.setDrugName(orderInfo.getDrugName());
        orderInfoDTO.setDrugAmount(orderInfo.getDrugAmount());
        orderInfoDTO.setDrugPrice(orderInfo.getDrugPrice());
        orderInfoDTO.setDrugsBarcode(orderInfo.getDrugs().getDrugsBarcode());
        orderInfoDTO.setOrderId(orderInfo.getOrder().getOrderId());

        return orderInfoDTO;
    }
    public OrderInfoDTO convertEntityToDTO(Optional<OrderInfo> orderInfo){
        OrderInfoDTO orderInfoDTO=new OrderInfoDTO();
        orderInfoDTO.setOrderInfoId(orderInfo.get().getOrderInfoId());
        orderInfoDTO.setDrugName(orderInfo.get().getDrugName());
        orderInfoDTO.setDrugAmount(orderInfo.get().getDrugAmount());
        orderInfoDTO.setDrugPrice(orderInfo.get().getDrugPrice());
        orderInfoDTO.setDrugsBarcode(orderInfo.get().getDrugs().getDrugsBarcode());
        orderInfoDTO.setOrderId(orderInfo.get().getOrder().getOrderId());
        return orderInfoDTO;
    }

    public List<OrderInfoDTO> convertEntityListToDTO(List<OrderInfo> ordersInfos){
        List  orderInfoDTO= new ArrayList() ;
        for (OrderInfo oi:ordersInfos){
            orderInfoDTO.add(convertEntityToDTO(oi));
        }
        return orderInfoDTO;
    }

}
