package com.keroles.Pharmacy.Repository.Operation;

import com.keroles.Pharmacy.Model.Entity.DeliveryMan;
import com.keroles.Pharmacy.Model.Entity.Drugs;

import java.util.List;
import java.util.Optional;


public interface DrugsRepoOp {
    Drugs insertDrugs(Drugs drugs);

    boolean updateDrugs(Drugs updatedDrugs);

    boolean deleteDrugs(String id);

    Optional<Drugs> findDrugsById(String id);

    List<Drugs> findPagingDrugs(int pageNumber, int pageSize, String sortField);

    List<Drugs> findAllDrugs();

    List<Drugs> findDrugsByName(String name);

}
