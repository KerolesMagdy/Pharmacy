package com.keroles.Pharmacy.Repository.Operation;

import com.keroles.Pharmacy.Model.Entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CompanyJpaRepo extends JpaRepository<Company,Integer> {

    @Query("select c from Company c where c.name like %:name%")
    List<Company> findCompanyByName(String name);

}
