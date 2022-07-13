package com.keroles.Pharmacy.Controller;

import com.keroles.Pharmacy.DTO.Model.DrugsDTO;
import com.keroles.Pharmacy.Model.Entity.Drugs;
import com.keroles.Pharmacy.Service.Implementation.DrugsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.keroles.Pharmacy.Constant.ConstantURI.*;

@RestController
@RequestMapping(drugs_uri)
public class DrugsController {
    @Autowired
    DrugsServiceImpl drugsServiceImpl;

    @RequestMapping( method = RequestMethod.POST)
    public DrugsDTO addDrugs(@Valid @RequestBody Drugs drugs) {
        return drugsServiceImpl.save(drugs);
    }

    @RequestMapping( method = RequestMethod.PUT)
    public void updateDrugs(@RequestBody Drugs drugs) {
        drugsServiceImpl.updateDrugs(drugs);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void removeDrugs(@PathVariable("id") String id) {
        drugsServiceImpl.removeDrugs(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public RepresentationModel<DrugsDTO> findDrugsById(@PathVariable("id") String id) {
        return drugsServiceImpl.getDrugsById(id);
    }

    @RequestMapping(value = page_uri, method = RequestMethod.GET)
    public List<DrugsDTO> findPagingDrugs(@RequestParam int pageNumber, @RequestParam int pageSize) {
        return drugsServiceImpl.getPagingDrugs(pageNumber, pageSize);
    }

    @RequestMapping( method = RequestMethod.GET)
    public List<DrugsDTO> getAllDrugs() {
        return drugsServiceImpl.getAllDrugs();
    }

    @RequestMapping(value = drugs_name_uri, method = RequestMethod.GET)
    public List<DrugsDTO> getAllDrugsByName(@RequestParam(value = "drugsName") String drugsName) {
        return drugsServiceImpl.getDrugsByName(drugsName);
    }



}
