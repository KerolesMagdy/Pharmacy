package com.keroles.Pharmacy.DTO.Model;

import com.keroles.Pharmacy.Model.Entity.Order;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
public class DeliveryManDTO extends RepresentationModel<DeliveryManDTO> implements Serializable {
    private Integer deliveryManId;
    private String deliveryManName;
    private long deliveryManPhone;
    private double deliveryManLat;
    private double deliveryManLong;
    private Long deliveryManNationalId;
    private float deliveryManTotalRate;
    private int deliveryManRateCount;
    private AddressDTO address;

}
