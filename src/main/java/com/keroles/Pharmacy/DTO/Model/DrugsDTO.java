package com.keroles.Pharmacy.DTO.Model;

import com.keroles.Pharmacy.Model.Entity.Company;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

@Data
public class DrugsDTO extends RepresentationModel<DrugsDTO> {
    private String drugsBarcode;
    private String companyName;
    private String drugsName;
    private String type;
    private String dose;
    private double costPrice;
    private double sellingPrice;
    private Date productionDate;
    private Date expirationDate;
    private String place;
    private int quantity;
}
