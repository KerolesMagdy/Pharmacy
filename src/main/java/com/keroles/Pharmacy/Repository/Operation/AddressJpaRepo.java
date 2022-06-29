/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keroles.Pharmacy.Repository.Operation;

import com.keroles.Pharmacy.Model.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author Keroles Magdy
 */
@Repository
public interface AddressJpaRepo extends JpaRepository<Address, Integer> {

    List<String> getCitiesInGovernorate(String governorate);
    List<String> getAllGovernorates();
    @Query("select a from Address a where a.governorate like %?1% and  a.city like %?2%")
    List<Address> getAddressByCityAndGovernorate(String governorate, String city);
}
