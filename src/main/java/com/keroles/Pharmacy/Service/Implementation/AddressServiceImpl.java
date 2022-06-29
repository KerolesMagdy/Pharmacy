/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keroles.Pharmacy.Service.Implementation;

import com.keroles.Pharmacy.DTO.Mapper.AddressMapper;
import com.keroles.Pharmacy.DTO.Model.AddressDTO;
import com.keroles.Pharmacy.Exception.Exceptions.AddressNotFoundException;
import com.keroles.Pharmacy.Exception.Exceptions.UserNotFoundException;
import com.keroles.Pharmacy.Model.Entity.Address;
import com.keroles.Pharmacy.Repository.Implementation.AddressRepoImpl;
import com.keroles.Pharmacy.Service.Operation.AddressServiceOp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

import static com.keroles.Pharmacy.Constant.ConstantExceptionPhrases.*;
import static com.keroles.Pharmacy.Constant.ConstantURI.address_uri;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 *
 * @author Keroles Magdy
 */
@Component
public class AddressServiceImpl implements AddressServiceOp {

    @Autowired
    private AddressRepoImpl addressRepoImpl;
    @Autowired
    private AddressMapper addressMapper;

    @Override
    public Address save(Address address) {
        return  addressRepoImpl.insertAddress(address);
    }

    @Override
    public void update(Address address) {
        if( !addressRepoImpl.updateAddress(address))
            throw new UserNotFoundException(not_found_address_to_update);

    }

    @Override
    public void remove(int id) {
        if( !addressRepoImpl.deleteAddress(id))
            throw new AddressNotFoundException(not_found_address_to_delete);
    }

    @Override
    public RepresentationModel<AddressDTO> getAddressById(int id) {
        Optional<Address> address=addressRepoImpl.findAddressById(id);
        if (!address.isPresent()) {
            throw new AddressNotFoundException(not_found_address_to_search);
        }

        Link link = linkTo(methodOn(this.getClass()).getAllAddresses())
                .slash(address_uri)
                .withRel("Addresses");
        RepresentationModel<AddressDTO> representationModel = addressMapper.ConvertEntityToUserAddressDOT(address).add(link);
        return representationModel;
    }

    @Override
    public List<AddressDTO> getPagingAddress(int pageNumber, int pageSize) {
        List<Address> addresses = addressRepoImpl.findPagingAddress(pageNumber, pageSize, "addressId");
        if (addresses.isEmpty()) {
            throw new AddressNotFoundException(not_found_address_to_paging);
        }
        return addressMapper.convertEntityListToDTO(addresses);
    }

    @Override
    public List<AddressDTO> getAllAddresses() {
        List<Address> addresses = addressRepoImpl.findAllAddress();
        if (addresses.isEmpty()) {
            throw new AddressNotFoundException(not_found_address);
        }
        return addressMapper.convertEntityListToDTO(addresses);
    }

    @Override
    public List<String> getAllGovernorates() {
        List<String> governorates= addressRepoImpl.getAllGovernorates();
        if(governorates.isEmpty()){
            throw new AddressNotFoundException(not_found_address_governorate);
        }
        return governorates;
    }

    @Override
    public List<String> getCitiesInGovernorate(String governorate) {
        List<String> cities= addressRepoImpl.getCitiesInGovernorate(governorate);
        if(cities.isEmpty()){
            throw new AddressNotFoundException(not_found_address_cities_in_governorate);
        }
        return cities;
    }

    @Override
    public List<AddressDTO> getAddressByCityAndGovernorate(String governorate, String city) {
        List<Address> addresses=addressRepoImpl.getAddressByCityAndGovernorate(governorate,city);
        if(addresses.isEmpty()){
            throw new AddressNotFoundException(not_found_address);
        }
        return addressMapper.convertEntityListToDTO(addresses);
    }
}
