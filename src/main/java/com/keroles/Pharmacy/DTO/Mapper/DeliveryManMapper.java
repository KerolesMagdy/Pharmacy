package com.keroles.Pharmacy.DTO.Mapper;

import com.keroles.Pharmacy.DTO.Model.CompanyDTO;
import com.keroles.Pharmacy.DTO.Model.DeliveryManDTO;
import com.keroles.Pharmacy.Model.Entity.Company;
import com.keroles.Pharmacy.Model.Entity.DeliveryMan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DeliveryManMapper {
    @Autowired
    private AddressMapper addressMapper;

    public DeliveryManDTO convertEntityToDTO(DeliveryMan deliveryMan){
        DeliveryManDTO deliveryManDTO=new DeliveryManDTO();
        deliveryManDTO.setDeliveryManId(deliveryMan.getDeliveryManId());
        deliveryManDTO.setDeliveryManName(deliveryMan.getDeliveryManName());
        deliveryManDTO.setDeliveryManPhone(deliveryMan.getDeliveryManPhone());
        deliveryManDTO.setDeliveryManNationalId(deliveryMan.getDeliveryManNationalId());
        deliveryManDTO.setAddress(addressMapper.ConvertEntityToUserAddressDOT(deliveryMan.getAddress()));
        deliveryManDTO.setDeliveryManTotalRate(deliveryMan.getDeliveryManTotalRate());
        deliveryManDTO.setDeliveryManRateCount(deliveryMan.getDeliveryManRateCount());
        deliveryManDTO.setDeliveryManLat(deliveryMan.getDeliveryManLat());
        deliveryManDTO.setDeliveryManLong(deliveryMan.getDeliveryManLong());
        return deliveryManDTO;
    }

    public DeliveryManDTO convertEntityToDTO(Optional<DeliveryMan> deliveryMan){
        DeliveryManDTO deliveryManDTO=new DeliveryManDTO();
        deliveryManDTO.setDeliveryManId(deliveryMan.get().getDeliveryManId());
        deliveryManDTO.setDeliveryManName(deliveryMan.get().getDeliveryManName());
        deliveryManDTO.setDeliveryManPhone(deliveryMan.get().getDeliveryManPhone());
        deliveryManDTO.setDeliveryManNationalId(deliveryMan.get().getDeliveryManNationalId());
        deliveryManDTO.setAddress(addressMapper.ConvertEntityToUserAddressDOT(deliveryMan.get().getAddress()));
        deliveryManDTO.setDeliveryManTotalRate(deliveryMan.get().getDeliveryManTotalRate());
        deliveryManDTO.setDeliveryManRateCount(deliveryMan.get().getDeliveryManRateCount());
        deliveryManDTO.setDeliveryManLat(deliveryMan.get().getDeliveryManLat());
        deliveryManDTO.setDeliveryManLong(deliveryMan.get().getDeliveryManLong());
        return deliveryManDTO;
    }

    public List<DeliveryManDTO> convertEntityListToDTO(List<DeliveryMan> deliveryMEN){
        List  deliveryManDTO= new ArrayList() ;
        for (DeliveryMan d:deliveryMEN){
            deliveryManDTO.add(convertEntityToDTO(d));
        }
        return deliveryManDTO;
    }


}
