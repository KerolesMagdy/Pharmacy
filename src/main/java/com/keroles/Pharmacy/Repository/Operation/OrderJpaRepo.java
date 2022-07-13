package com.keroles.Pharmacy.Repository.Operation;

import com.keroles.Pharmacy.Model.Entity.Drugs;
import com.keroles.Pharmacy.Model.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface OrderJpaRepo extends JpaRepository<Order,Integer> {

    public List<Order> findOrdersByDeliveryMan_DeliveryManId(int deliveryManId);
    public List<Order> findOrdersByDeliveryMan_DeliveryManNationalId(long deliveryManNationalId);
    public List<Order> findOrdersByEmployee_EmpId(int employeeId);
    public List<Order> findOrdersByEmployee_EmpName(String employeeName);
    public List<Order> findOrdersByUsers_UserId(int userId);
    public List<Order> findOrdersByUsers_UserName(String userName);
    public List<Order> findOrdersByOrderDatetime(Date date);
    public List<Order> findOrdersByPaymentStatus(boolean paymentStatus);
    public List<Order> findOrdersByDeliverStatus(String deliverStatus);
    public List<Order> findOrdersByTotalCashGreaterThan(float totalCash);
    public List<Order> findOrdersByTotalCashLessThan(float totalCash);

    @Modifying
    @Transactional
    @Query("update Order o set o.deliveryMan.deliveryManId= :deliveryManById where o.orderId = :orderId")
    public int updateOrderDeliveryManById(int orderId , int deliveryManById);

    @Modifying
    @Transactional
    @Query("update Order o set o.deliverStatus= :deliverStatus where o.orderId = :orderId")
    public int updateOrderDeliveryStatusById(int orderId , String deliverStatus);

    @Modifying
    @Transactional
    @Query("update Order o set o.paymentStatus= :paymentStatus where o.orderId = :orderId")
    public int updateOrderPaymentStatusById(int orderId , boolean paymentStatus);

    @Modifying
    @Transactional
    @Query("update Order o set o.orderLat= :orderLat , o.orderLong= :orderLong  where o.orderId = :orderId")
    public int updateOrderLatLongById(int orderId,float orderLat,float orderLong);


}
