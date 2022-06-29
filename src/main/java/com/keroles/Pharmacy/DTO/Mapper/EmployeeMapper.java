package com.keroles.Pharmacy.DTO.Mapper;


import com.keroles.Pharmacy.DTO.Model.EmployeeDTO;
import com.keroles.Pharmacy.Model.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class EmployeeMapper {

    @Autowired
    private AddressMapper addressMapper;

    public EmployeeDTO ConvertEntityToEmployeeDTO(Employee employee){
        EmployeeDTO employeeDTO=new EmployeeDTO();
        employeeDTO.setEmpId(employee.getEmpId());
        employeeDTO.setEmpName(employee.getEmpName());
        employeeDTO.setEmpType(employee.isEmpType());
        employeeDTO.setEmpEmail(employee.getEmpEmail());
        employeeDTO.setEmpPhone(employee.getEmpPhone());
        employeeDTO.setEmpImage(employee.getEmpImage());
        employeeDTO.setEmpNationalId(employee.getEmpNationalId());
        employeeDTO.setAddress(addressMapper.ConvertEntityToUserAddressDOT(employee.getAddress()));
        return employeeDTO;
    }
    public EmployeeDTO ConvertEntityToEmployeeDTO(Optional<Employee> employee){
        EmployeeDTO employeeDTO=new EmployeeDTO();
        employeeDTO.setEmpId(employee.get().getEmpId());
        employeeDTO.setEmpName(employee.get().getEmpName());
        employeeDTO.setEmpType(employee.get().isEmpType());
        employeeDTO.setEmpEmail(employee.get().getEmpEmail());
        employeeDTO.setEmpPhone(employee.get().getEmpPhone());
        employeeDTO.setEmpImage(employee.get().getEmpImage());
        employeeDTO.setEmpNationalId(employee.get().getEmpNationalId());
        employeeDTO.setAddress(addressMapper.ConvertEntityToUserAddressDOT(employee.get().getAddress()));
        return employeeDTO;
    }

    public List<EmployeeDTO> convertEntityListToDTO(List<Employee> employees){
        List  employeeDTO= new ArrayList() ;
        for (Employee u:employees){
            employeeDTO.add(ConvertEntityToEmployeeDTO(u));
        }
        return employeeDTO;
    }
}
