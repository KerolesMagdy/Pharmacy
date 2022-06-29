package com.keroles.Pharmacy.Controller;

import com.keroles.Pharmacy.DTO.Model.AddressDTO;
import com.keroles.Pharmacy.Model.Entity.Address;
import com.keroles.Pharmacy.Service.Implementation.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.bind.annotation.*;
import javax.servlet.ServletContext;
import javax.validation.Valid;
import java.util.List;

import static com.keroles.Pharmacy.Constant.ConstantURI.*;

@RestController
@RequestMapping(address_uri)
public class AddressController {

    @Autowired
    AddressServiceImpl addressService;

    @Autowired
    ServletContext context;

    @RequestMapping( method = RequestMethod.POST)
    public Address addAddress(@Valid @RequestBody Address address) {
        return addressService.save(address);
    }

    @RequestMapping( method = RequestMethod.PUT)
    public void updateAddress(@RequestBody Address address) {
        addressService.update(address);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void removeAddress(@PathVariable("id") Integer id) {
        addressService.remove(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public RepresentationModel<AddressDTO> findAddressById(@PathVariable("id") Integer addressId) {
        return addressService.getAddressById(addressId);
    }

    @RequestMapping(value = page_uri, method = RequestMethod.GET)
    public List<AddressDTO> findPagingUsers(@RequestParam int pageNumber, @RequestParam int pageSize) {
        return addressService.getPagingAddress(pageNumber, pageSize);
    }

    @RequestMapping( method = RequestMethod.GET)
    public List<AddressDTO> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @RequestMapping( method = RequestMethod.GET,value = address_governorate_uri)
    public List<String> getAllGovernorates() {
        return addressService.getAllGovernorates();
    }

    @RequestMapping(method = RequestMethod.GET ,value = address_governorate_uri +"/{governorate}")
    public List<String> getCitiesInGovernorate(@PathVariable("governorate") String governorate){
        return addressService.getCitiesInGovernorate(governorate);
    }

    @RequestMapping(method = RequestMethod.POST,value = address_governorate_uri)
    public List<AddressDTO> findAddressByCityAndGovernorate(@RequestParam String governorate, @RequestParam String city) {
        return addressService.getAddressByCityAndGovernorate(governorate, city);
    }

}
