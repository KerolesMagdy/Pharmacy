package com.keroles.Pharmacy.Repository.Implementation;

import com.keroles.Pharmacy.Model.Entity.Order;
import com.keroles.Pharmacy.Repository.Operation.OrderJpaRepo;
import com.keroles.Pharmacy.Repository.Operation.OrderRepoOp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class OrderRepoImpl implements OrderRepoOp {

    @Autowired
    private OrderJpaRepo orderJpaRepo;

    @Override
    public Order insertOrder(Order order) {
        return orderJpaRepo.save(order);
    }

    @Override
    public boolean deleteOrder(int id) {
        if (!orderJpaRepo.existsById(id)) {
            return false;
        } else {
            orderJpaRepo.deleteById(id);
            return true;
        }
    }

    @Override
    public Optional<Order> findOrderById(int id) {
        return orderJpaRepo.findById(id);
    }

    @Override
    public List<Order> findPagingOrder(int pageNumber, int pageSize, String sortField) {
        Page<Order> orders = orderJpaRepo.findAll(new PageRequest(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, sortField)) {
        });
        return orders.getContent();
    }

    @Override
    public List<Order> findAllOrders() {
       return orderJpaRepo.findAll();
    }

    @Override
    public List<Order> findOrdersByDeliveryMan_DeliveryManId(int deliveryManId) {
        List<Order> orders = orderJpaRepo.findOrdersByDeliveryMan_DeliveryManId(deliveryManId);
        return orders;
    }

    @Override
    public List<Order> findOrdersByDeliveryMan_DeliveryManNationalId(long deliveryManNationalId) {
        List<Order> orders = orderJpaRepo.findOrdersByDeliveryMan_DeliveryManNationalId(deliveryManNationalId);
        return orders;
    }

    @Override
    public List<Order> findOrdersByEmployee_EmpId(int employeeId) {
        List<Order> orders = orderJpaRepo.findOrdersByEmployee_EmpId(employeeId);
        return orders;
    }

    @Override
    public List<Order> findOrdersByEmployee_EmpName(String employeeName) {
        List<Order> orders = orderJpaRepo.findOrdersByEmployee_EmpName(employeeName);
        return orders;
    }

    @Override
    public List<Order> findOrdersByUsers_UserId(int userId) {
        List<Order> orders = orderJpaRepo.findOrdersByUsers_UserId(userId);
        return orders;
    }

    @Override
    public List<Order> findOrdersByUsers_UserName(String userName) {
        List<Order> orders = orderJpaRepo.findOrdersByUsers_UserName(userName);
        return orders;
    }

    @Override
    public List<Order> findOrdersByOrderDatetime(Date date) {
        List<Order> orders = orderJpaRepo.findOrdersByOrderDatetime(date);
        return orders;
    }

    @Override
    public List<Order> findOrdersByPaymentStatus(boolean paymentStatus) {
        List<Order> orders = orderJpaRepo.findOrdersByPaymentStatus(paymentStatus);
        return orders;
    }

    @Override
    public List<Order> findOrdersByDeliverStatus(String deliverStatus) {
        List<Order> orders = orderJpaRepo.findOrdersByDeliverStatus(deliverStatus);
        return orders;
    }

    @Override
    public List<Order> findOrdersByTotalCashGreaterThan(float totalCash) {
        List<Order> orders = orderJpaRepo.findOrdersByTotalCashGreaterThan(totalCash);
        return orders;
    }

    @Override
    public List<Order> findOrdersByTotalCashLessThan(float totalCash) {
        List<Order> orders = orderJpaRepo.findOrdersByTotalCashLessThan(totalCash);
        return orders;
    }

    @Override
    public boolean updateOrder(Order updatedOrder) {
        try {
            Optional<Order> searchOrder= findOrderById(updatedOrder.getOrderId());
            if (!searchOrder.isPresent())
                return false;
            Order existOrder=searchOrder.get();
            existOrder.Transfer(updatedOrder);
            orderJpaRepo.save(existOrder);
        }catch (Exception e){
            return false;
        }

        return true;
    }

    @Override
    public int updateOrderDeliveryManById(int orderId, int deliveryManById) {

        return orderJpaRepo.updateOrderDeliveryManById(orderId,deliveryManById);
    }

    @Override
    public int updateOrderDeliveryStatusById(int orderId, String deliverStatus) {
        return orderJpaRepo.updateOrderDeliveryStatusById(orderId,deliverStatus);
    }

    @Override
    public int updateOrderPaymentStatusById(int orderId, boolean paymentStatus) {
        return orderJpaRepo.updateOrderPaymentStatusById(orderId,paymentStatus);
    }

    @Override
    public int updateOrderLatLong(int orderId, float orderLat, float orderLong) {
        return orderJpaRepo.updateOrderLatLongById(orderId,orderLat,orderLong);
    }


}
