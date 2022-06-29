package com.keroles.Pharmacy.Repository.Operation;

import com.keroles.Pharmacy.Model.Entity.DeliveryMan;
import org.springframework.data.geo.Point;

import java.util.List;
import java.util.Optional;

public interface DeliveryManRepoOp {

    DeliveryMan insertDeliveryMan(DeliveryMan deliveryMan);

    boolean updateDeliveryMan(DeliveryMan updatedDeliveryMan);

    boolean deleteDeliveryMan(int id);

    Optional<DeliveryMan> findDeliveryManById(int id);

    List<DeliveryMan> findPagingCDeliveryMan(int pageNumber, int pageSize, String sortField);

    List<DeliveryMan> findAllDeliveryMan();

    List<DeliveryMan> findDeliveryManByName(String name);

    List<DeliveryMan> findNearestDeliveryMan(double deliveryManLat,double deliveryManLong);

}
