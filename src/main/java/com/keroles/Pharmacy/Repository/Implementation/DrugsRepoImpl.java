package com.keroles.Pharmacy.Repository.Implementation;

import com.keroles.Pharmacy.Model.Entity.DeliveryMan;
import com.keroles.Pharmacy.Model.Entity.Drugs;
import com.keroles.Pharmacy.Repository.Operation.DrugsJpaRepo;
import com.keroles.Pharmacy.Repository.Operation.DrugsRepoOp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DrugsRepoImpl implements DrugsRepoOp {

    @Autowired
    DrugsJpaRepo drugsJpaRepo;

    @Override
    public Drugs insertDrugs(Drugs drugs) {
        return drugsJpaRepo.save(drugs);
    }

    @Override
    public boolean updateDrugs(Drugs updatedDrugs) {
        try {
            Optional<Drugs> searchDrugs= findDrugsById(updatedDrugs.getDrugsBarcode());
            if (!searchDrugs.isPresent())
                return false;
            Drugs existDrugs=searchDrugs.get();
            existDrugs.Transfer(updatedDrugs);
            drugsJpaRepo.save(existDrugs);
        }catch (Exception e){
         return false;
        }

        return true;
    }

    @Override
    public boolean deleteDrugs(String id) {
        if (!drugsJpaRepo.existsById(id)) {
            return false;
        } else {
            drugsJpaRepo.deleteById(id);
            return true;
        }    }

    @Override
    public Optional<Drugs> findDrugsById(String id) {
        Optional<Drugs> drugs = drugsJpaRepo.findById(id);

        return drugs;

    }

    @Override
    public List<Drugs> findPagingDrugs(int pageNumber, int pageSize, String sortField) {
        Page<Drugs> drugs = drugsJpaRepo.findAll(new PageRequest(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, sortField)) {
        });
        return drugs.getContent();
    }

    @Override
    public List<Drugs> findAllDrugs() {
        List<Drugs> drugs = drugsJpaRepo.findAll();
        return drugs;
    }

    @Override
    public List<Drugs> findDrugsByName(String name) {
        return drugsJpaRepo.findDrugsByDrugsNameContains(name);
    }
}
