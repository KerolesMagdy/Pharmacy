/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keroles.Pharmacy.Service.Operation;

import com.keroles.Pharmacy.DTO.Model.AddressDTO;
import com.keroles.Pharmacy.Model.Entity.Address;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

/**
 *
 * @author Keroles Magdy
 */
public interface AddressServiceOp {
    
        Address save(Address address);
        void update(Address address);
        void remove(int id);
        RepresentationModel<AddressDTO> getAddressById(int id);
        List<AddressDTO> getPagingAddress(int pageNumber, int pageSize);
        List<AddressDTO> getAllAddresses();
        List<String> getAllGovernorates();
        List<String> getCitiesInGovernorate(String governorate);
        List<AddressDTO> getAddressByCityAndGovernorate(String governorate, String city);

}
