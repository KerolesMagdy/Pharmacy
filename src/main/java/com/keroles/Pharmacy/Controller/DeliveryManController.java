package com.keroles.Pharmacy.Controller;

import com.keroles.Pharmacy.DTO.Model.CompanyDTO;
import com.keroles.Pharmacy.DTO.Model.DeliveryManDTO;
import com.keroles.Pharmacy.Model.Entity.Company;
import com.keroles.Pharmacy.Model.Entity.DeliveryMan;
import com.keroles.Pharmacy.Repository.Implementation.DeliveryManRepoImpl;
import com.keroles.Pharmacy.Repository.Operation.DeliveryManJpaRepo;
import com.keroles.Pharmacy.Service.Implementation.DeliveryManServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.keroles.Pharmacy.Constant.ConstantURI.*;

@RestController
@RequestMapping(delivery_man_uri)
public class DeliveryManController {

    @Autowired
    DeliveryManServiceImpl deliveryManServiceImpl;

    @RequestMapping( method = RequestMethod.POST)
    public DeliveryManDTO addDeliveryMan(@Valid @RequestBody DeliveryMan deliveryMan) {
        return deliveryManServiceImpl.save(deliveryMan);
    }

    @RequestMapping( method = RequestMethod.PUT)
    public void updateDeliveryMan(@RequestBody DeliveryMan deliveryMan) {
        deliveryManServiceImpl.updateDeliveryMan(deliveryMan);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void removeDeliveryMan(@PathVariable("id") Integer id) {
        deliveryManServiceImpl.removeDeliveryMan(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public RepresentationModel<DeliveryManDTO> findDeliveryManById(@PathVariable("id") Integer id) {
        return deliveryManServiceImpl.getDeliveryManById(id);
    }

    @RequestMapping(value = page_uri, method = RequestMethod.GET)
    public List<DeliveryManDTO> findPagingDeliveryMan(@RequestParam int pageNumber, @RequestParam int pageSize) {
        return deliveryManServiceImpl.getPagingDeliveryMan(pageNumber, pageSize);
    }

    @RequestMapping( method = RequestMethod.GET)
    public List<DeliveryManDTO> getAllDeliveryMen() {
        return deliveryManServiceImpl.getAllDeliveryMen();
    }

    @RequestMapping(value = delivery_man_name_uri, method = RequestMethod.GET)
    public List<DeliveryManDTO> getAllCompanyByName(@RequestParam(value = "delivName") String deliveryManName) {
        return deliveryManServiceImpl.getDeliveryManByName(deliveryManName);
    }

    @RequestMapping(value = delivery_man_distance_uri,method = RequestMethod.POST)
    public List<DeliveryManDTO> getAllNearestDeliveryMenByName(@RequestParam(value = "deliveryManLat") double deliveryManLat, @RequestParam(value = "deliveryManLong") double deliveryManLong) {
        return deliveryManServiceImpl.getNearestDeliveryMan(deliveryManLat,deliveryManLong);
    }

}
