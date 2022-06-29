/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keroles.Pharmacy.DTO.Mapper;

import com.keroles.Pharmacy.DTO.Model.AddressDTO;
import com.keroles.Pharmacy.Model.Entity.Address;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Keroles Magdy
 */
@Component
public class AddressMapper {
    
    public AddressDTO ConvertEntityToUserAddressDOT(Address address){
        AddressDTO addressDOT=new AddressDTO();
        addressDOT.setAddressId(address.getAddressId());
        addressDOT.setAddressTitle(address.getAddressTitle());
        addressDOT.setCity(address.getCity());
        addressDOT.setGovernorate(address.getGovernorate());
        return addressDOT;
    }
    public AddressDTO ConvertEntityToUserAddressDOT(Optional<Address>address){
        AddressDTO addressDOT=new AddressDTO();
        addressDOT.setAddressId(address.get().getAddressId());
        addressDOT.setAddressTitle(address.get().getAddressTitle());
        addressDOT.setCity(address.get().getCity());
        addressDOT.setGovernorate(address.get().getGovernorate());
        return addressDOT;
    }

    public List<AddressDTO> convertEntityListToDTO(List<Address> addresses){
        List  usersAddressDTO= new ArrayList() ;
        for (Address u:addresses){
            usersAddressDTO.add(ConvertEntityToUserAddressDOT(u));
        }
        return usersAddressDTO;
    }
}
