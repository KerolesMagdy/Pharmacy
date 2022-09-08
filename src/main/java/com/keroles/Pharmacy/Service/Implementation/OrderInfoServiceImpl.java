package com.keroles.Pharmacy.Service.Implementation;

import com.keroles.Pharmacy.DTO.Mapper.OrderInfoMapper;
import com.keroles.Pharmacy.DTO.Model.OrderDTO;
import com.keroles.Pharmacy.DTO.Model.OrderInfoDTO;
import com.keroles.Pharmacy.Exception.Exceptions.OrderInfoNotFroundException;
import com.keroles.Pharmacy.Exception.Exceptions.OrderNotFroundException;
import com.keroles.Pharmacy.Model.Entity.OrderInfo;
import com.keroles.Pharmacy.Repository.Implementation.OrderInfoRepoImpl;
import com.keroles.Pharmacy.Service.Operation.OrderInfoServiceOp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static com.keroles.Pharmacy.Constant.ConstantExceptionPhrases.*;
import static com.keroles.Pharmacy.Constant.ConstantURI.order_info_uri;
import static com.keroles.Pharmacy.Constant.ConstantURI.order_uri;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class OrderInfoServiceImpl implements OrderInfoServiceOp {

    @Autowired
    OrderInfoRepoImpl orderInfoRepoImpl;
    @Autowired
    OrderInfoMapper orderInfoMapper;

    @Override
    public OrderInfoDTO save(OrderInfo orderInfo) {
        if (!(orderInfo.getOrder().getOrderId()!=null))
            throw new OrderInfoNotFroundException(not_found_Order_Info_order_id);
        else if (!(orderInfo.getDrugs().getDrugsBarcode()!=null))
            throw new OrderNotFroundException(not_found_Order_Info_drugs_barcode);
        else {
            OrderInfoDTO insertedOrderInfo=orderInfoMapper.convertEntityToDTO(orderInfoRepoImpl.insertOrderInfo(orderInfo));
            return insertedOrderInfo;
        }
    }

    @Override
    public void removeOrderInfo(int id) {
        if (!orderInfoRepoImpl.deleteOrderInfo(id)) {
            throw new OrderInfoNotFroundException(not_found_Order_Info_to_delete);
        }
    }

    @Override
    public int updateOrderInfoDrugAmountById(int orderInfoId, int drugAmount) {
        if(Integer.valueOf(drugAmount).equals(null)||drugAmount<0){
            throw new OrderNotFroundException(not_found_Order_Info_drugs_amount_to_update);
        }
        int result =orderInfoRepoImpl.updateOrderInfoDrugAmountById(orderInfoId, drugAmount);
        if (result==0) {
            throw new OrderNotFroundException(not_found_Order_Info_to_update);
        }
        return result;
    }

    @Override
    public RepresentationModel<OrderInfoDTO> getOrderInfoById(int id) {
        Optional<OrderInfo> orderInfos = orderInfoRepoImpl.findOrderInfoById(id);
        if (!orderInfos.isPresent()) {
            throw new OrderInfoNotFroundException(not_found_Order_Info_to_search);
        }

        Link link = linkTo(methodOn(this.getClass()).getAllOrderInfos())
                .slash(order_uri)
                .withRel("order infos");
        RepresentationModel<OrderInfoDTO> representationModel = orderInfoMapper.convertEntityToDTO(orderInfos).add(link);
        return representationModel;
    }

    @Override
    public List<OrderInfoDTO> getOrderInfoByOrder_OrderId(int orderId) {

        List<OrderInfo> orderInfos=orderInfoRepoImpl.findOrderInfoByOrder_OrderId(orderId);
        if (orderInfos.isEmpty()){
            throw new OrderInfoNotFroundException(not_found_Order_Info_to_search);
        }
        Link link = linkTo(methodOn(this.getClass()).getAllOrderInfos())
                .slash(order_info_uri)
                .withRel("order infos");
        List<OrderInfoDTO> orderInfoDTOS = orderInfoMapper.convertEntityListToDTO(orderInfos);
        return orderInfoDTOS;
    }

    @Override
    public List<OrderInfoDTO> getPagingOrderInfo(int pageNumber, int pageSize) {
        List<OrderInfo> orderInfos = orderInfoRepoImpl.findPagingOrderInfo(pageNumber, pageSize, "orderInfoId");
        if (orderInfos.isEmpty()) {
            throw new OrderInfoNotFroundException(not_found_Order_Info_to_paging);
        }
        return orderInfoMapper.convertEntityListToDTO(orderInfos);
    }

    @Override
    public List<OrderInfoDTO> getAllOrderInfos() {
        List<OrderInfo> orderInfos = orderInfoRepoImpl.findAllOrderInfos();
        if (orderInfos.isEmpty()) {
            throw new OrderInfoNotFroundException(not_found_Order_Info);
        }
        return orderInfoMapper.convertEntityListToDTO(orderInfos);
    }





}
