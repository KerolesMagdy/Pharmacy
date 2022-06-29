package com.keroles.Pharmacy.Service.Operation;

import com.keroles.Pharmacy.DTO.Model.EmployeeDTO;
import com.keroles.Pharmacy.Model.Entity.Employee;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

public interface EmployeeServiceOp {
    EmployeeDTO save(Employee employee);
    void updateBasicInfo(Employee employee);
    void remove(int id);
    RepresentationModel<EmployeeDTO> getEmployeeById(int id);
    List<EmployeeDTO> getPagingEmployee(int pageNumber, int pageSize);
    List<EmployeeDTO> getAllEmployee();
    List<EmployeeDTO> findEmpByType(boolean type);
    List<EmployeeDTO> findEmpByTypeAndId(boolean type, int id);
    void updateEmpByTypeAndId( int id,boolean eType);
}
