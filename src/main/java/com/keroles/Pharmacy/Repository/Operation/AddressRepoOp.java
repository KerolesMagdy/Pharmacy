/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keroles.Pharmacy.Repository.Operation;

import com.keroles.Pharmacy.Model.Entity.Address;
import com.keroles.Pharmacy.Model.Entity.Users;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Keroles Magdy
 */
public interface AddressRepoOp {
    public Address insertAddress(Address address);

    public boolean updateAddress(Address address);

    public boolean deleteAddress(int id);

    public Optional<Address> findAddressById(int id);

    public List<Address> findPagingAddress(int pageNumber, int pageSize,String sortField);

    public List<Address> findAllAddress();



}
