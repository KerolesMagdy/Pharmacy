/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keroles.Pharmacy.Service.Implementation;

import com.keroles.Pharmacy.DTO.Mapper.UserAddressMapper;
import com.keroles.Pharmacy.DTO.Model.UserAddressDOT;
import com.keroles.Pharmacy.Model.Entity.Address;
import com.keroles.Pharmacy.Model.Entity.Users;
import com.keroles.Pharmacy.Repository.Implementation.AddressRepoImpl;
import com.keroles.Pharmacy.Service.Operation.AddressServiceOp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Keroles Magdy
 */
@Component
public class AddressServiceImpl implements AddressServiceOp {

    @Autowired
    private AddressRepoImpl addressRepoImpl;
    @Autowired
    private UserAddressMapper userAddressMapper;

    @Override
    public Address save(Address address) {
        return  addressRepoImpl.insertAddress(address);
    }

    @Override
    public void update(Address address) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserAddressDOT getAddressById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UserAddressDOT> getPagingAddress(int pageNumber, int pageSize,String sortField) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UserAddressDOT> getAllAddresses() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
