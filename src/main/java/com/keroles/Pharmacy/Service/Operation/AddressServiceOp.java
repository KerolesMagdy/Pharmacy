/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keroles.Pharmacy.Service.Operation;

import com.keroles.Pharmacy.DTO.Model.UserAddressDOT;
import com.keroles.Pharmacy.Model.Entity.Address;
import com.keroles.Pharmacy.Model.Entity.Users;
import java.util.List;

/**
 *
 * @author Keroles Magdy
 */
public interface AddressServiceOp {
    
        Address save(Address address);
        void update(Address address);
        void remove(int id);
        UserAddressDOT getAddressById(int id);
        List<UserAddressDOT> getPagingAddress(int pageNumber, int pageSize,String sortField);
        List<UserAddressDOT> getAllAddresses();
}
