package com.keroles.Pharmacy.DTO.Model;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@Data
public class EmployeeDTO extends RepresentationModel<EmployeeDTO> implements Serializable {
    private Integer empId;
    private String empName;
    private boolean empType;
    private long empPhone;
    private String empEmail;
    private String empImage;
    private long empNationalId;
    private AddressDTO address;

}
