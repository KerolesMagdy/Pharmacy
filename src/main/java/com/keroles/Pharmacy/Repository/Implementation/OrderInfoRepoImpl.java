package com.keroles.Pharmacy.Repository.Implementation;

import com.keroles.Pharmacy.Model.Entity.OrderInfo;
import com.keroles.Pharmacy.Repository.Operation.OrderInfoJpaRepo;
import com.keroles.Pharmacy.Repository.Operation.OrderInfoRepoOp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class OrderInfoRepoImpl implements OrderInfoRepoOp {

    @Autowired
    OrderInfoJpaRepo orderInfoJpaRepo;

    @Override
    public OrderInfo insertOrderInfo(OrderInfo order) {
        return orderInfoJpaRepo.save(order);
    }

    @Override
    public boolean deleteOrderInfo(int id) {
        if (!orderInfoJpaRepo.existsById(id)) {
            return false;
        } else {
            orderInfoJpaRepo.deleteById(id);
            return true;
        }
    }

    @Override
    public Optional<OrderInfo> findOrderInfoById(int id) {
        return orderInfoJpaRepo.findById(id);
    }

    @Override
    public List<OrderInfo> findPagingOrderInfo(int pageNumber, int pageSize, String sortField) {
        Page<OrderInfo> orders = orderInfoJpaRepo.findAll(new PageRequest(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, sortField)) {
        });
        return orders.getContent();
    }


    @Override
    public List<OrderInfo> findAllOrderInfos() {
        return orderInfoJpaRepo.findAll();
    }

    @Override
    public List<OrderInfo> findOrderInfoByOrder_OrderId(int orderId) {
        return orderInfoJpaRepo.findOrderInfoByOrder_OrderId(orderId);
    }

    @Override
    public int updateOrderInfoDrugAmountById(int orderInfoId, int drugAmount) {
        return orderInfoJpaRepo.updateOrderInfoDrugAmountById(orderInfoId,drugAmount);
    }
}
