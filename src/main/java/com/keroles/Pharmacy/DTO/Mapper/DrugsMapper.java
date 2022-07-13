package com.keroles.Pharmacy.DTO.Mapper;

import com.keroles.Pharmacy.DTO.Model.DrugsDTO;
import com.keroles.Pharmacy.Model.Entity.Drugs;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DrugsMapper {

    public DrugsDTO convertEntityToDTO(Drugs drugs){
        DrugsDTO drugsDTO=new DrugsDTO();
        drugsDTO.setDrugsBarcode(drugs.getDrugsBarcode());
        drugsDTO.setDrugsName(drugs.getDrugsName());
        drugsDTO.setCompanyName(drugs.getCompany().getName());
        drugsDTO.setDose(drugs.getDose());
        drugsDTO.setCostPrice(drugs.getCostPrice());
        drugsDTO.setSellingPrice(drugs.getSellingPrice());
        drugsDTO.setType(drugs.getType());
        drugsDTO.setProductionDate(drugs.getProductionDate());
        drugsDTO.setExpirationDate(drugs.getExpirationDate());
        drugsDTO.setPlace(drugs.getPlace());
        drugsDTO.setQuantity(drugs.getQuantity());
        return drugsDTO;
    }
    public DrugsDTO convertEntityToDTO(Optional<Drugs> drugs){
        DrugsDTO drugsDTO=new DrugsDTO();
        drugsDTO.setDrugsBarcode(drugs.get().getDrugsBarcode());
        drugsDTO.setDrugsName(drugs.get().getDrugsName());
        drugsDTO.setCompanyName(drugs.get().getCompany().getName());
        drugsDTO.setDose(drugs.get().getDose());
        drugsDTO.setCostPrice(drugs.get().getCostPrice());
        drugsDTO.setSellingPrice(drugs.get().getSellingPrice());
        drugsDTO.setType(drugs.get().getType());
        drugsDTO.setProductionDate(drugs.get().getProductionDate());
        drugsDTO.setExpirationDate(drugs.get().getExpirationDate());
        drugsDTO.setPlace(drugs.get().getPlace());
        drugsDTO.setQuantity(drugs.get().getQuantity());
        return drugsDTO;
    }

    public List<DrugsDTO> convertEntityListToDTO(List<Drugs> drugs){
        List  drugsDTO= new ArrayList() ;
        for (Drugs d:drugs){
            drugsDTO.add(convertEntityToDTO(d));
        }
        return drugsDTO;
    }

}
