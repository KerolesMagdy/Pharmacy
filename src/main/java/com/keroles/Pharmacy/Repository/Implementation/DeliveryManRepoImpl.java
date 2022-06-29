package com.keroles.Pharmacy.Repository.Implementation;

import com.keroles.Pharmacy.Model.Entity.DeliveryMan;
import com.keroles.Pharmacy.Repository.Operation.DeliveryManJpaRepo;
import com.keroles.Pharmacy.Repository.Operation.DeliveryManRepoOp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DeliveryManRepoImpl implements DeliveryManRepoOp {

    @Autowired
    DeliveryManJpaRepo deliveryManJpaRepo;
    @Override
    public DeliveryMan insertDeliveryMan(DeliveryMan deliveryMan) {
        return deliveryManJpaRepo.save(deliveryMan);
    }

    @Override
    public boolean updateDeliveryMan(DeliveryMan updatedDeliveryMan) {
        try {
            Optional<DeliveryMan> searchDeliveryMan = findDeliveryManById(updatedDeliveryMan.getDeliveryManId());
            if (!searchDeliveryMan.isPresent()) {
                return false;
            }
            DeliveryMan existDeliveryMan=searchDeliveryMan.get();
            existDeliveryMan.Transfer(updatedDeliveryMan);
            deliveryManJpaRepo.save(existDeliveryMan);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteDeliveryMan(int id) {
        if (!deliveryManJpaRepo.existsById(id)) {
            return false;
        } else {
            deliveryManJpaRepo.deleteById(id);
            return true;
        }    }

    @Override
    public Optional<DeliveryMan> findDeliveryManById(int id) {
        Optional<DeliveryMan> deliveryMan = deliveryManJpaRepo.findById(id);

        return deliveryMan;
    }

    @Override
    public List<DeliveryMan> findPagingCDeliveryMan(int pageNumber, int pageSize, String sortField) {
        Page<DeliveryMan> deliveryMEN = deliveryManJpaRepo.findAll(new PageRequest(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, sortField)) {
        });
        return deliveryMEN.getContent();    }

    @Override
    public List<DeliveryMan> findAllDeliveryMan() {

        List<DeliveryMan> deliveryMEN = deliveryManJpaRepo.findAll();
        return deliveryMEN;
    }

    @Override
    public List<DeliveryMan> findDeliveryManByName(String name) {
        return deliveryManJpaRepo.findDeliveryManByName(name);
    }

    @Override
    public List<DeliveryMan> findNearestDeliveryMan(double deliveryManLat, double deliveryManLong) {
        return deliveryManJpaRepo.findNearestDeliveryMan(deliveryManLat,deliveryManLong);
    }
}
