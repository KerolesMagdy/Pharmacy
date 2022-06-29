package com.keroles.Pharmacy.Repository.Operation;

import com.keroles.Pharmacy.Model.Entity.DeliveryMan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DeliveryManJpaRepo extends JpaRepository<DeliveryMan,Integer> {

    @Query( value = "select * from delivery_man d where sqrt(POWER(69.1 * ( :deliveryManLat - d.delivery_man_lat),2) +POWER(69.1 * ( d.delivery_man_long- :deliveryManLong ) * COS(:deliveryManLat / 57.3), 2))<100",
    nativeQuery = true)
    List<DeliveryMan> findNearestDeliveryMan(double deliveryManLat,double deliveryManLong);

    @Query("select d from DeliveryMan d where d.deliveryManName like %:name%")
    List<DeliveryMan> findDeliveryManByName(String name);

}
