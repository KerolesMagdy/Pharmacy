package com.keroles.Pharmacy.Controller;

import com.keroles.Pharmacy.DTO.Model.OrderDTO;
import com.keroles.Pharmacy.Model.Entity.Order;
import com.keroles.Pharmacy.Service.Implementation.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

import static com.keroles.Pharmacy.Constant.ConstantURI.*;

@RestController
@RequestMapping(order_uri)
public class OrderController {
    @Autowired
    OrderServiceImpl orderServiceImpl;

    @RequestMapping( method = RequestMethod.POST)
    public OrderDTO addOrder(@Valid @RequestBody Order order) {
        return orderServiceImpl.save(order);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void removeOrder(@PathVariable("id") int id) {
        orderServiceImpl.removeOrder(id);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public RepresentationModel<OrderDTO> findOrderById(@PathVariable("id") int id) {
        return orderServiceImpl.getOrderById(id);
    }

    @RequestMapping( method = RequestMethod.GET)
    public List<OrderDTO> getAllOrder() {
        return orderServiceImpl.getAllOrders();
    }

    @RequestMapping(value = page_uri, method = RequestMethod.GET)
    public List<OrderDTO> findPagingOrder(@RequestParam int pageNumber, @RequestParam int pageSize) {
        return orderServiceImpl.getPagingOrder(pageNumber, pageSize);
    }


    @RequestMapping(value = order_delivery_man_id_uri+"/{id}", method = RequestMethod.GET)
    public List<OrderDTO> getAllOrderByDeliveryManId(@PathVariable("id") int deliveryManId) {
        return orderServiceImpl.getOrdersByDeliveryMan_DeliveryManId(deliveryManId);
    }
    @RequestMapping(value = order_delivery_man_national_id_uri+"/{national_id}", method = RequestMethod.GET)
    public List<OrderDTO> getAllOrderByDeliveryManNationalId(@PathVariable("national_id") long deliveryManNationalId) {
        return orderServiceImpl.getOrdersByDeliveryMan_DeliveryManNationalId(deliveryManNationalId);
    }
    @RequestMapping(value = order_employee_id_uri +"/{employee_id}", method = RequestMethod.GET)
    public List<OrderDTO> getAllOrderByEmpId(@PathVariable("employee_id") int employeeId) {
        return orderServiceImpl.getOrdersByEmployee_EmpId(employeeId);
    }
    @RequestMapping(value = order_employee_name_uri +"/{employee_name}", method = RequestMethod.GET)
    public List<OrderDTO> getAllOrderByEmpName(@PathVariable("employee_name") String employeeName) {
        return orderServiceImpl.getOrdersByEmployee_EmpName(employeeName);
    }
    @RequestMapping(value = order_user_id_uri+"/{user_id}", method = RequestMethod.GET)
    public List<OrderDTO> getAllOrderByUserId(@PathVariable("user_id") int userId) {
        return orderServiceImpl.getOrdersByUsers_UserId(userId);
    }
    @RequestMapping(value = order_user_name_uri+"/{user_name}", method = RequestMethod.GET)
    public List<OrderDTO> getAllOrderByUserName(@PathVariable("user_name") String deliveryManName) {
        return orderServiceImpl.getOrdersByUsers_UserName(deliveryManName);
    }
    @RequestMapping(value = order_date_uri+"/{date}", method = RequestMethod.GET)
    public List<OrderDTO> getAllOrderByDate(@PathVariable("date")@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date) {
        return orderServiceImpl.getOrdersByOrderDatetime(date);
    }
    @RequestMapping(value = order_payment_Status_uri+"/{payment_status}", method = RequestMethod.GET)
    public List<OrderDTO> getAllOrderByPaymentStatus(@PathVariable("payment_status") boolean paymentStatus) {
        return orderServiceImpl.getOrdersByPaymentStatus(paymentStatus);
    }
    @RequestMapping(value = order_delivery_status_uri+"/{delivery_status}", method = RequestMethod.GET)
    public List<OrderDTO> getAllOrderByDeliveryStatus(@PathVariable("delivery_status") String deliveryStatus) {
        return orderServiceImpl.getOrdersByDeliverStatus(deliveryStatus);
    }
    @RequestMapping(value = order_total_cash_greater_than_uri+"/{total_cash}", method = RequestMethod.GET)
    public List<OrderDTO> getAllOrderByTotalCashGreaterThan(@PathVariable("total_cash") float totalCash) {
        return orderServiceImpl.getOrdersByTotalCashGreaterThan(totalCash);
    }
    @RequestMapping(value = order_total_cash_less_than_uri+"/{total_cash}", method = RequestMethod.GET)
    public List<OrderDTO> getAllOrderByTotalCashLessThan(@PathVariable("total_cash") float totalCash) {
        return orderServiceImpl.getOrdersByTotalCashLessThan(totalCash);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateOrder(@RequestBody Order order) {
        orderServiceImpl.updateOrder(order);
    }
    @RequestMapping(value = order_update_delivery_man_id_uri +"/{orderId}",method = RequestMethod.PUT)
    public void updateOrderDeliveryManById(@PathVariable("orderId") int orderId,@RequestParam int deliveryManId) {
        orderServiceImpl.updateOrderDeliveryManById(orderId,deliveryManId);
    }
    @RequestMapping(value = order_update_delivery_status_uri +"/{orderId}",method = RequestMethod.PUT)
    public void updateOrderDeliveryStatusById(@PathVariable("orderId") int orderId,@RequestParam String deliveryStatus) {
        orderServiceImpl.updateOrderDeliveryStatusById(orderId,deliveryStatus);
    }
    @RequestMapping(value = order_update_payment_status_uri +"/{orderId}",method = RequestMethod.PUT)
    public void updateOrderPaymentStatusById(@PathVariable("orderId") int orderId,@RequestParam boolean paymentStatus) {
        orderServiceImpl.updateOrderPaymentStatusById(orderId,paymentStatus);
    }
    @RequestMapping(value = order_update_lat_long_uri +"/{orderId}",method = RequestMethod.PUT)
    public void updateOrderLatLongById(@PathVariable("orderId") int orderId,@RequestParam float lat,@RequestParam float lng) {
        orderServiceImpl.updateOrderLatLongById(orderId,lat,lng);
    }

}
