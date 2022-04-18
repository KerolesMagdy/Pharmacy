/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keroles.Pharmacy.Repository.Implementation;

import com.keroles.Pharmacy.Model.Entity.Address;
import com.keroles.Pharmacy.Repository.Operation.AddressJpaRepo;
import com.keroles.Pharmacy.Repository.Operation.AddressRepoOp;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

/**
 *
 * @author Keroles Magdy
 */
@Component
public class AddressRepoImpl implements AddressRepoOp {

    @Autowired
    AddressJpaRepo addressJpaRepo;

    @Override
    public Address insertAddress(Address address) {

        return addressJpaRepo.save(address);
    }

    @Override
    public boolean updateAddress(Address updatedAddress) {
        Address existAddress = findAddressById(updatedAddress.getAddressId()).get();
        if (existAddress == null) {
            return false;
        }
        existAddress.Transfer(updatedAddress);
        addressJpaRepo.save(existAddress);

        return true;
    }

    @Override
    public boolean deleteAddress(int id) {
        if (!addressJpaRepo.existsById(id)) {
            return false;
        } else {
            addressJpaRepo.deleteById(id);
            return true;
        }
    }

    @Override
    public Optional<Address> findAddressById(int id) {
        return addressJpaRepo.findById(id);
    }

    @Override
    public List<Address> findPagingAddress(int pageNumber, int pageSize,String sortField) {
        Page<Address> addresses =addressJpaRepo.findAll(new PageRequest(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, sortField)) {
        });
        return addresses.getContent();
    }

    @Override
    public List<Address> findAllAddress() {
        return addressJpaRepo.findAll();
    }

}
