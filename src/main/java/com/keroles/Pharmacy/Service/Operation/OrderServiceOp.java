package com.keroles.Pharmacy.Service.Operation;

import com.keroles.Pharmacy.DTO.Model.OrderDTO;
import com.keroles.Pharmacy.Model.Entity.Order;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;
import java.util.List;

public interface OrderServiceOp {

    OrderDTO save(Order order);

    void removeOrder(int id);

    RepresentationModel<OrderDTO> getOrderById(int id);

    List<OrderDTO> getPagingOrder(int pageNumber, int pageSize);

    List<OrderDTO> getAllOrders();

    public List<OrderDTO> getOrdersByDeliveryMan_DeliveryManId(int deliveryManId);

    public List<OrderDTO> getOrdersByDeliveryMan_DeliveryManNationalId(long deliveryManNationalId);

    public List<OrderDTO> getOrdersByEmployee_EmpId(int employeeId);

    public List<OrderDTO> getOrdersByEmployee_EmpName(String employeeName);

    public List<OrderDTO> getOrdersByUsers_UserId(int userId);

    public List<OrderDTO> getOrdersByUsers_UserName(String userName);

    public List<OrderDTO> getOrdersByOrderDatetime(Date date);

    public List<OrderDTO> getOrdersByPaymentStatus(boolean paymentStatus);

    public List<OrderDTO> getOrdersByDeliverStatus(String deliverStatus);

    public List<OrderDTO> getOrdersByTotalCashGreaterThan(float totalCash);

    public List<OrderDTO> getOrdersByTotalCashLessThan(float totalCash);

    void updateOrder(Order updatedOrder);

    public void updateOrderDeliveryManById(int orderId , int deliveryManById);

    public void updateOrderDeliveryStatusById(int orderId , String deliverStatus);

    public void updateOrderPaymentStatusById(int orderId , boolean paymentStatus);

    public void updateOrderLatLongById(int orderId,float orderLat,float orderLong);
}
