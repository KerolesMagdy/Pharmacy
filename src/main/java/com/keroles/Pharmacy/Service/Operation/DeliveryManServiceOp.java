package com.keroles.Pharmacy.Service.Operation;

import com.keroles.Pharmacy.DTO.Model.CompanyDTO;
import com.keroles.Pharmacy.DTO.Model.DeliveryManDTO;
import com.keroles.Pharmacy.Model.Entity.Company;
import com.keroles.Pharmacy.Model.Entity.DeliveryMan;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

public interface DeliveryManServiceOp {
    DeliveryManDTO save(DeliveryMan deliveryMan);

    void updateDeliveryMan(DeliveryMan updatedDeliveryMan);

    void removeDeliveryMan(int id);

    RepresentationModel<DeliveryManDTO> getDeliveryManById(int id);

    List<DeliveryManDTO> getPagingDeliveryMan(int pageNumber, int pageSize);

    List<DeliveryManDTO> getAllDeliveryMen();

    List<DeliveryManDTO> getDeliveryManByName(String name);

    List<DeliveryManDTO> getNearestDeliveryMan(double deliveryManLat,double deliveryManLong);

}
