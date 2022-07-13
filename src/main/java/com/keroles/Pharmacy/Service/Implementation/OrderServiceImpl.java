package com.keroles.Pharmacy.Service.Implementation;

import com.keroles.Pharmacy.DTO.Mapper.OrderMapper;
import com.keroles.Pharmacy.DTO.Model.OrderDTO;
import com.keroles.Pharmacy.Exception.Exceptions.DeliveryManNotFoundException;
import com.keroles.Pharmacy.Exception.Exceptions.OrderNotFroundException;
import com.keroles.Pharmacy.Model.Entity.Order;
import com.keroles.Pharmacy.Repository.Implementation.DeliveryManRepoImpl;
import com.keroles.Pharmacy.Repository.Implementation.EmployeeRepoImpl;
import com.keroles.Pharmacy.Repository.Implementation.OrderRepoImpl;
import com.keroles.Pharmacy.Repository.Implementation.UserRepoImpl;
import com.keroles.Pharmacy.Service.Operation.OrderServiceOp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.keroles.Pharmacy.Constant.ConstantExceptionPhrases.*;
import static com.keroles.Pharmacy.Constant.ConstantURI.order_uri;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class OrderServiceImpl implements OrderServiceOp {

    @Autowired
    private OrderRepoImpl orderRepoImpl;
    @Autowired
    private DeliveryManRepoImpl deliveryManRepoImpl;
    @Autowired
    private EmployeeRepoImpl employeeRepoImpl;
    @Autowired
    private UserRepoImpl userRepoImpl;


    @Autowired
    OrderMapper orderMapper;
    @Override
    public OrderDTO save(Order order) {
        if (!(order.getDeliveryMan().getDeliveryManId()!=null))
            throw new OrderNotFroundException(not_found_Order_delivery_man_parameter);
        else if (!(order.getEmployee().getEmpId()!=null))
            throw new OrderNotFroundException(not_found_Order_employee_id_parameter);
        else if (!(order.getUsers().getUserId()!=null))
            throw new OrderNotFroundException(not_found_Order_user_parameter);
        else {
            OrderDTO insertedOrder=orderMapper.convertEntityToDTO(orderRepoImpl.insertOrder(order));
            insertedOrder.setDeliveryManName(deliveryManRepoImpl.findDeliveryManById(insertedOrder.getDeliveryManId()).get().getDeliveryManName());
            insertedOrder.setEmployeeName(employeeRepoImpl.findEmployeeById(insertedOrder.getEmployeeId()).get().getEmpName());
            insertedOrder.setUsersName(userRepoImpl.findUserById(insertedOrder.getUsersId()).get().getUserName());
            return insertedOrder;
        }
    }

    @Override
    public void removeOrder(int id) {
        if (!orderRepoImpl.deleteOrder(id)) {
            throw new OrderNotFroundException(not_found_Order_to_delete);
        }
    }

    @Override
    public RepresentationModel<OrderDTO> getOrderById(int id) {
        Optional<Order> orders = orderRepoImpl.findOrderById(id);
        if (!orders.isPresent()) {
            throw new OrderNotFroundException(not_found_Order_to_search);
        }

        Link link = linkTo(methodOn(this.getClass()).getAllOrders())
                .slash(order_uri)
                .withRel("orders");
        RepresentationModel<OrderDTO> representationModel = orderMapper.convertEntityToDTO(orders).add(link);
        return representationModel;
    }

    @Override
    public List<OrderDTO> getPagingOrder(int pageNumber, int pageSize) {
        List<Order> orders = orderRepoImpl.findPagingOrder(pageNumber, pageSize, "orderId");
        if (orders.isEmpty()) {
            throw new OrderNotFroundException(not_found_Order_to_paging);
        }
        return orderMapper.convertEntityListToDTO(orders);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderRepoImpl.findAllOrders();
        if (orders.isEmpty()) {
            throw new OrderNotFroundException(not_found_Order);
        }
        return orderMapper.convertEntityListToDTO(orders);
    }

    @Override
    public List<OrderDTO> getOrdersByDeliveryMan_DeliveryManId(int deliveryManId) {
        List<Order> orders = orderRepoImpl.findOrdersByDeliveryMan_DeliveryManId(deliveryManId);
        if (orders.isEmpty()) {
            throw new OrderNotFroundException(not_found_Order);
        }
        return orderMapper.convertEntityListToDTO(orders);
    }

    @Override
    public List<OrderDTO> getOrdersByDeliveryMan_DeliveryManNationalId(long deliveryManNationalId) {
        List<Order> orders = orderRepoImpl.findOrdersByDeliveryMan_DeliveryManNationalId(deliveryManNationalId);
        if (orders.isEmpty()) {
            throw new OrderNotFroundException(not_found_Order);
        }
        return orderMapper.convertEntityListToDTO(orders);
    }

    @Override
    public List<OrderDTO> getOrdersByEmployee_EmpId(int employeeId) {
        List<Order> orders = orderRepoImpl.findOrdersByEmployee_EmpId(employeeId);
        if (orders.isEmpty()) {
            throw new OrderNotFroundException(not_found_Order);
        }
        return orderMapper.convertEntityListToDTO(orders);
    }

    @Override
    public List<OrderDTO> getOrdersByEmployee_EmpName(String employeeName) {
        List<Order> orders = orderRepoImpl.findOrdersByEmployee_EmpName(employeeName);
        if (orders.isEmpty()) {
            throw new OrderNotFroundException(not_found_Order);
        }
        return orderMapper.convertEntityListToDTO(orders);
    }

    @Override
    public List<OrderDTO> getOrdersByUsers_UserId(int userId) {
        List<Order> orders = orderRepoImpl.findOrdersByUsers_UserId(userId);
        if (orders.isEmpty()) {
            throw new OrderNotFroundException(not_found_Order);
        }
        return orderMapper.convertEntityListToDTO(orders);
    }

    @Override
    public List<OrderDTO> getOrdersByUsers_UserName(String userName) {
        List<Order> orders = orderRepoImpl.findOrdersByUsers_UserName(userName);
        if (orders.isEmpty()) {
            throw new OrderNotFroundException(not_found_Order);
        }
        return orderMapper.convertEntityListToDTO(orders);
    }

    @Override
    public List<OrderDTO> getOrdersByOrderDatetime(Date date) {
        List<Order> orders = orderRepoImpl.findOrdersByOrderDatetime(date);
        if (orders.isEmpty()) {
            throw new OrderNotFroundException(not_found_Order);
        }
        return orderMapper.convertEntityListToDTO(orders);
    }

    @Override
    public List<OrderDTO> getOrdersByPaymentStatus(boolean paymentStatus) {
        List<Order> orders = orderRepoImpl.findOrdersByPaymentStatus(paymentStatus);
        if (orders.isEmpty()) {
            throw new OrderNotFroundException(not_found_Order);
        }
        return orderMapper.convertEntityListToDTO(orders);
    }

    @Override
    public List<OrderDTO> getOrdersByDeliverStatus(String deliverStatus) {
        List<Order> orders = orderRepoImpl.findOrdersByDeliverStatus(deliverStatus);
        if (orders.isEmpty()) {
            throw new OrderNotFroundException(not_found_Order);
        }
        return orderMapper.convertEntityListToDTO(orders);
    }

    @Override
    public List<OrderDTO> getOrdersByTotalCashGreaterThan(float totalCash) {
        List<Order> orders = orderRepoImpl.findOrdersByTotalCashGreaterThan(totalCash);
        if (orders.isEmpty()) {
            throw new OrderNotFroundException(not_found_Order);
        }
        return orderMapper.convertEntityListToDTO(orders);
    }

    @Override
    public List<OrderDTO> getOrdersByTotalCashLessThan(float totalCash) {
        List<Order> orders = orderRepoImpl.findOrdersByTotalCashLessThan(totalCash);
        if (orders.isEmpty()) {
            throw new OrderNotFroundException(not_found_Order);
        }
        return orderMapper.convertEntityListToDTO(orders);
    }

    @Override
    public void updateOrder(Order updatedOrder) {
        if (updatedOrder.getOrderId()==null)
            throw new OrderNotFroundException(not_found_Order_id_to_update);
        if (!orderRepoImpl.updateOrder(updatedOrder))
            throw new OrderNotFroundException(not_found_Order_to_update);
    }

    @Override
    public void updateOrderDeliveryManById(int orderId, int deliveryManById) {
        if(!deliveryManRepoImpl.findDeliveryManById(deliveryManById).isPresent())
            throw new DeliveryManNotFoundException(not_found_delivery_man_to_update);
        else if (orderRepoImpl.updateOrderDeliveryManById(orderId,deliveryManById)==0)
            throw new OrderNotFroundException(not_found_Order_to_update);
    }

    @Override
    public void updateOrderDeliveryStatusById(int orderId, String deliverStatus) {
        if (orderRepoImpl.updateOrderDeliveryStatusById(orderId,deliverStatus)==0)
            throw new OrderNotFroundException(not_found_Order_to_update);
    }

    @Override
    public void updateOrderPaymentStatusById(int orderId, boolean paymentStatus) {
        if (orderRepoImpl.updateOrderPaymentStatusById(orderId,paymentStatus)==0)
            throw new OrderNotFroundException(not_found_Order_to_update);
    }

    @Override
    public void updateOrderLatLongById(int orderId, float orderLat, float orderLong) {
        if (orderRepoImpl.updateOrderLatLong(orderId,orderLat,orderLong)==0)
            throw new OrderNotFroundException(not_found_Order_to_update);
    }
}
