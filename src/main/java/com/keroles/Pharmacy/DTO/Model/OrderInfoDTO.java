package com.keroles.Pharmacy.DTO.Model;

import com.keroles.Pharmacy.Model.Entity.Drugs;
import com.keroles.Pharmacy.Model.Entity.Order;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@Data
public class OrderInfoDTO extends RepresentationModel<OrderInfoDTO> implements Serializable {


    private Integer orderInfoId;
    private String drugsBarcode;
    private Integer orderId;
    private String drugName;
    private float drugPrice;
    private int drugAmount;
}
