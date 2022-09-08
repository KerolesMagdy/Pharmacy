package com.keroles.Pharmacy.Controller;

import com.keroles.Pharmacy.DTO.Model.OrderInfoDTO;
import com.keroles.Pharmacy.DTO.Model.UserDTO;
import com.keroles.Pharmacy.Model.Entity.OrderInfo;
import com.keroles.Pharmacy.Model.Entity.Users;
import com.keroles.Pharmacy.Service.Implementation.OrderInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.keroles.Pharmacy.Constant.ConstantURI.*;

@RestController
@RequestMapping(order_info_uri)
public class OrderInfoController {

    @Autowired
    OrderInfoServiceImpl orderInfoServiceImpl;

    @RequestMapping( method = RequestMethod.POST)
    public OrderInfoDTO addOrderInfo(@Valid @RequestBody OrderInfo orderInfo) {
        return orderInfoServiceImpl.save(orderInfo);
    }

    @RequestMapping( method = RequestMethod.PUT,value =order_info_amount_uri )
    public void updateOrderInfoDrugAmount(@RequestParam int orderInfoId,@RequestParam int drugAmount) {
        orderInfoServiceImpl.updateOrderInfoDrugAmountById(orderInfoId, drugAmount);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void removeOrderInfo(@PathVariable("id") Integer id) {
        orderInfoServiceImpl.removeOrderInfo(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public RepresentationModel<OrderInfoDTO> findOrderInfoById(@PathVariable("id") Integer orderInfoId) {
        return orderInfoServiceImpl.getOrderInfoById(orderInfoId);
    }

    @RequestMapping( method = RequestMethod.GET)
    public List<OrderInfoDTO> findOrderInfoByOrder_OrderId(@RequestParam("order_id") Integer orderId) {
        return orderInfoServiceImpl.getOrderInfoByOrder_OrderId(orderId);
    }

    @RequestMapping(value = page_uri, method = RequestMethod.GET)
    public List<OrderInfoDTO> findPagingOrderInfos(@RequestParam int pageNumber, @RequestParam int pageSize) {
        return orderInfoServiceImpl.getPagingOrderInfo(pageNumber, pageSize);
    }

    @RequestMapping( value ="/all",method = RequestMethod.GET)
    public List<OrderInfoDTO> getAllOrderInfos() {
        return orderInfoServiceImpl.getAllOrderInfos();
    }
}
