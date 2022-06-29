package com.keroles.Pharmacy.DTO.Model;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;
import java.io.Serializable;

@Data
public class CompanyDTO extends RepresentationModel<CompanyDTO> implements Serializable {

    private Integer companyId;
    private String name;
    private String phone;
    private String logo;
    private AddressDTO addressDTO;
}
