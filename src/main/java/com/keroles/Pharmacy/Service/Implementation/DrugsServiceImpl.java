package com.keroles.Pharmacy.Service.Implementation;

import com.keroles.Pharmacy.DTO.Mapper.DrugsMapper;
import com.keroles.Pharmacy.DTO.Model.DeliveryManDTO;
import com.keroles.Pharmacy.DTO.Model.DrugsDTO;
import com.keroles.Pharmacy.Exception.Exceptions.AddressNotFoundException;
import com.keroles.Pharmacy.Exception.Exceptions.DeliveryManNotFoundException;
import com.keroles.Pharmacy.Exception.Exceptions.DrugsNotFoundException;
import com.keroles.Pharmacy.Model.Entity.DeliveryMan;
import com.keroles.Pharmacy.Model.Entity.Drugs;
import com.keroles.Pharmacy.Repository.Implementation.AddressRepoImpl;
import com.keroles.Pharmacy.Repository.Implementation.CompanyRepoImpl;
import com.keroles.Pharmacy.Repository.Implementation.DrugsRepoImpl;
import com.keroles.Pharmacy.Service.Operation.DrugsServiceOp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static com.keroles.Pharmacy.Constant.ConstantExceptionPhrases.*;
import static com.keroles.Pharmacy.Constant.ConstantURI.delivery_man_uri;
import static com.keroles.Pharmacy.Constant.ConstantURI.drugs_uri;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class DrugsServiceImpl implements DrugsServiceOp {
    @Autowired
    DrugsRepoImpl drugsRepoImpl;
    @Autowired
    CompanyRepoImpl companyRepoImpl;
    @Autowired
    AddressRepoImpl addressRepoImpl;
    @Autowired
    DrugsMapper drugsMapper;

    @Override
    public DrugsDTO save(Drugs drugs) {
        if(drugsRepoImpl.findDrugsById(drugs.getDrugsBarcode()).isPresent())
            throw new DrugsNotFoundException(found_Drugs_to_insert);
        else if (addressRepoImpl.insertAddress(drugs.getCompany().getAddress())!=null&&companyRepoImpl.insertCompany(drugs.getCompany()) != null) {
            return drugsMapper.convertEntityToDTO(drugsRepoImpl.insertDrugs(drugs));
        } else {
            return null;
        }
    }

    @Override
    public void updateDrugs(Drugs updatedDrugs) {
        if (!drugsRepoImpl.updateDrugs(updatedDrugs))
            throw new DrugsNotFoundException(not_found_Drugs_to_update);
    }

    @Override
    public void removeDrugs(String id) {
        if (!drugsRepoImpl.deleteDrugs(id)) {
            throw new DrugsNotFoundException(not_found_Drugs_to_delete);
        }
    }

    @Override
    public RepresentationModel<DrugsDTO> getDrugsById(String id) {
        Optional<Drugs> drugs = drugsRepoImpl.findDrugsById(id);
        if (!drugs.isPresent()) {
            throw new DrugsNotFoundException(not_found_Drugs_to_search);
        }

        Link link = linkTo(methodOn(this.getClass()).getAllDrugs())
                .slash(drugs_uri)
                .withRel("drugs");
        RepresentationModel<DrugsDTO> representationModel = drugsMapper.convertEntityToDTO(drugs).add(link);
        return representationModel;
    }

    @Override
    public List<DrugsDTO> getPagingDrugs(int pageNumber, int pageSize) {
        List<Drugs> drugs = drugsRepoImpl.findPagingDrugs(pageNumber, pageSize, "drugsBarcode");
        if (drugs.isEmpty()) {
            throw new DrugsNotFoundException(not_found_Drugs_to_paging);
        }
        return drugsMapper.convertEntityListToDTO(drugs);    }

    @Override
    public List<DrugsDTO> getAllDrugs() {
        List<Drugs> drugs = drugsRepoImpl.findAllDrugs();
        if (drugs.isEmpty()) {
            throw new DrugsNotFoundException(not_found_Drugs);
        }
        return drugsMapper.convertEntityListToDTO(drugs);
    }

    @Override
    public List<DrugsDTO> getDrugsByName(String drugsName) {
        List<Drugs> drugs = drugsRepoImpl.findDrugsByName(drugsName);
        if (drugs.isEmpty()) {
            throw new DrugsNotFoundException(not_found_Drugs);
        }
        return drugsMapper.convertEntityListToDTO(drugs);
    }
}
