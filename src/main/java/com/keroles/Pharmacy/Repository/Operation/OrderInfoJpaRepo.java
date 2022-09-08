package com.keroles.Pharmacy.Repository.Operation;

import com.keroles.Pharmacy.Model.Entity.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderInfoJpaRepo extends JpaRepository<OrderInfo,Integer> {

    public List<OrderInfo> findOrderInfoByOrder_OrderId(int orderId);

    @Modifying
    @Transactional
    @Query("update OrderInfo oi set oi.drugAmount= :drugAmount where oi.orderInfoId = :orderInfoId")
    public int updateOrderInfoDrugAmountById(int orderInfoId , int drugAmount);
}
