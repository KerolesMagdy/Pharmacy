package com.keroles.Pharmacy.Repository.Operation;

import com.keroles.Pharmacy.Model.Entity.OrderInfo;

import java.util.List;
import java.util.Optional;


public interface OrderInfoRepoOp {
    OrderInfo insertOrderInfo(OrderInfo order);

    boolean deleteOrderInfo(int id);

    Optional<OrderInfo> findOrderInfoById(int id);

    public List<OrderInfo> findOrderInfoByOrder_OrderId(int orderId);

    List<OrderInfo> findPagingOrderInfo(int pageNumber, int pageSize, String sortField);

    List<OrderInfo> findAllOrderInfos();

    public int updateOrderInfoDrugAmountById(int orderInfoId, int drugAmount);

}
