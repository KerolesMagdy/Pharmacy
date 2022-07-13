package com.keroles.Pharmacy.Repository.Operation;

import com.keroles.Pharmacy.Model.Entity.Drugs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrugsJpaRepo extends JpaRepository<Drugs,String> {

    public List<Drugs> findDrugsByDrugsNameContains(String drugsName);

}
