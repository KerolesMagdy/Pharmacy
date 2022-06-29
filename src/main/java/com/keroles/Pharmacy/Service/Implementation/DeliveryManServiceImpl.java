package com.keroles.Pharmacy.Service.Implementation;

import com.keroles.Pharmacy.DTO.Mapper.DeliveryManMapper;
import com.keroles.Pharmacy.DTO.Model.DeliveryManDTO;
import com.keroles.Pharmacy.Exception.Exceptions.DeliveryManNotFoundException;
import com.keroles.Pharmacy.Model.Entity.DeliveryMan;
import com.keroles.Pharmacy.Repository.Implementation.AddressRepoImpl;
import com.keroles.Pharmacy.Repository.Implementation.DeliveryManRepoImpl;
import com.keroles.Pharmacy.Service.Operation.DeliveryManServiceOp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static com.keroles.Pharmacy.Constant.ConstantExceptionPhrases.*;
import static com.keroles.Pharmacy.Constant.ConstantURI.delivery_man_uri;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class DeliveryManServiceImpl implements DeliveryManServiceOp {
    @Autowired
    DeliveryManRepoImpl deliveryManRepoImpl;
    @Autowired
    AddressRepoImpl addressRepoImpl;
    @Autowired
    DeliveryManMapper deliveryManMapper;
    @Override
    public DeliveryManDTO save(DeliveryMan deliveryMan) {
        if (addressRepoImpl.insertAddress(deliveryMan.getAddress()) != null) {
            return deliveryManMapper.convertEntityToDTO(deliveryManRepoImpl.insertDeliveryMan(deliveryMan));
        } else {
            return null;
        }
    }

    @Override
    public void updateDeliveryMan(DeliveryMan updatedDeliveryMan) {
        if (!deliveryManRepoImpl.updateDeliveryMan(updatedDeliveryMan)) {
            throw new DeliveryManNotFoundException(not_found_delivery_man_to_update);
        }
    }

    @Override
    public void removeDeliveryMan(int id) {
        if (!deliveryManRepoImpl.deleteDeliveryMan(id)) {
            throw new DeliveryManNotFoundException(not_found_delivery_man_to_delete);
        }
    }

    @Override
    public RepresentationModel<DeliveryManDTO> getDeliveryManById(int id) {
        Optional<DeliveryMan> deliveryMan = deliveryManRepoImpl.findDeliveryManById(id);
        if (!deliveryMan.isPresent()) {
            throw new DeliveryManNotFoundException(not_found_delivery_man_to_search);
        }

        Link link = linkTo(methodOn(this.getClass()).getAllDeliveryMen())
                .slash(delivery_man_uri)
                .withRel("delivery man");
        RepresentationModel<DeliveryManDTO> representationModel = deliveryManMapper.convertEntityToDTO(deliveryMan).add(link);
        return representationModel;
    }

    @Override
    public List<DeliveryManDTO> getPagingDeliveryMan(int pageNumber, int pageSize) {
        List<DeliveryMan> deliveryMEN = deliveryManRepoImpl.findPagingCDeliveryMan(pageNumber, pageSize, "companyId");
        if (deliveryMEN.isEmpty()) {
            throw new DeliveryManNotFoundException(not_found_delivery_man_to_paging);
        }
        return deliveryManMapper.convertEntityListToDTO(deliveryMEN);
    }

    @Override
    public List<DeliveryManDTO> getAllDeliveryMen() {
        List<DeliveryMan> deliveryMEN = deliveryManRepoImpl.findAllDeliveryMan();
        if (deliveryMEN.isEmpty()) {
            throw new DeliveryManNotFoundException(not_found_delivery_man);
        }
        return deliveryManMapper.convertEntityListToDTO(deliveryMEN);    }

    @Override
    public List<DeliveryManDTO> getDeliveryManByName(String name) {
        List<DeliveryMan> deliveryMEN = deliveryManRepoImpl.findDeliveryManByName(name);
        if (deliveryMEN.isEmpty()) {
            throw new DeliveryManNotFoundException(not_found_delivery_man);
        }
        return deliveryManMapper.convertEntityListToDTO(deliveryMEN);    }

    @Override
    public List<DeliveryManDTO> getNearestDeliveryMan(double deliveryManLat, double deliveryManLong) {
        List<DeliveryMan> deliveryMEN = deliveryManRepoImpl.findNearestDeliveryMan(deliveryManLat,deliveryManLong);
        if (deliveryMEN.isEmpty()) {
            throw new DeliveryManNotFoundException(not_found_delivery_man);
        }
        return deliveryManMapper.convertEntityListToDTO(deliveryMEN);
    }
}
