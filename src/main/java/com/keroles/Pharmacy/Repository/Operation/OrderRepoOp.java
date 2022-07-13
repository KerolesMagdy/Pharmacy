package com.keroles.Pharmacy.Repository.Operation;

import com.keroles.Pharmacy.Model.Entity.Employee;
import com.keroles.Pharmacy.Model.Entity.Order;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface OrderRepoOp {


    Order insertOrder(Order order);

    boolean deleteOrder(int id);

    Optional<Order> findOrderById(int id);

    List<Order> findPagingOrder(int pageNumber, int pageSize, String sortField);

    List<Order> findAllOrders();

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

    boolean updateOrder(Order updatedOrder);

    public int updateOrderDeliveryManById(int orderId , int deliveryManById);

    public int updateOrderDeliveryStatusById(int orderId , String deliverStatus);

    public int updateOrderPaymentStatusById(int orderId , boolean paymentStatus);

    public int updateOrderLatLong(int orderId,float orderLat,float orderLong);

}
