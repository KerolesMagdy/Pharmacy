/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keroles.Pharmacy.DTO.Mapper;

import com.keroles.Pharmacy.DTO.Model.UserAddressDOT;
import com.keroles.Pharmacy.Model.Entity.Address;
import org.springframework.stereotype.Component;

/**
 *
 * @author Keroles Magdy
 */
@Component
public class UserAddressMapper {
    
    public UserAddressDOT ConvertEntityToUserAddressDOT(Address address){
        UserAddressDOT addressDOT=new UserAddressDOT();
        addressDOT.setAddressId(address.getAddressId());
        addressDOT.setAddressTitle(address.getAddressTitle());
        addressDOT.setCity(address.getCity());
        addressDOT.setGovernorate(address.getGovernorate());
        return addressDOT;
    }
    
}
