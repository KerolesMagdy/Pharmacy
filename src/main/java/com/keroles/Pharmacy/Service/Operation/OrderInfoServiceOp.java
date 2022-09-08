package com.keroles.Pharmacy.Service.Operation;

import com.keroles.Pharmacy.DTO.Model.OrderInfoDTO;
import com.keroles.Pharmacy.Model.Entity.OrderInfo;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;
import java.util.Optional;

public interface OrderInfoServiceOp {
    OrderInfoDTO save(OrderInfo order);

    void removeOrderInfo(int id);

    RepresentationModel<OrderInfoDTO> getOrderInfoById(int id);

    public List<OrderInfoDTO> getOrderInfoByOrder_OrderId(int orderId);

    List<OrderInfoDTO> getPagingOrderInfo(int pageNumber, int pageSize);

    List<OrderInfoDTO> getAllOrderInfos();

    public int updateOrderInfoDrugAmountById(int orderInfoId, int drugAmount);

}
