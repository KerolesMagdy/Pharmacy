package com.keroles.Pharmacy.Service.Implementation;

import com.keroles.Pharmacy.DTO.Mapper.EmployeeMapper;
import com.keroles.Pharmacy.DTO.Model.EmployeeDTO;
import com.keroles.Pharmacy.Exception.Exceptions.AddressNotFoundException;
import com.keroles.Pharmacy.Exception.Exceptions.EmployeeNotFoundException;
import com.keroles.Pharmacy.Exception.Exceptions.UserNotFoundException;
import com.keroles.Pharmacy.Model.Entity.Employee;
import com.keroles.Pharmacy.Repository.Implementation.AddressRepoImpl;
import com.keroles.Pharmacy.Repository.Implementation.EmployeeRepoImpl;
import com.keroles.Pharmacy.Service.Operation.EmployeeServiceOp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static com.keroles.Pharmacy.Constant.ConstantExceptionPhrases.*;
import static com.keroles.Pharmacy.Constant.ConstantURI.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class EmployeeServiceImpl implements EmployeeServiceOp {

    @Autowired
    EmployeeRepoImpl employeeRepoImpl;
    @Autowired
    AddressRepoImpl addressRepoImpl;
    @Autowired
    EmployeeMapper employeeMapper;
    @Override
    public EmployeeDTO save(Employee employee) {
        if (addressRepoImpl.insertAddress(employee.getAddress()) != null) {
            return employeeMapper.ConvertEntityToEmployeeDTO(employeeRepoImpl.insertEmployee(employee));
        } else {
            return null;
        }
    }

    @Override
    public void updateBasicInfo(Employee employee) {
        if (!employeeRepoImpl.updateEmployeeBasicInfo(employee))
            throw new EmployeeNotFoundException(not_found_employee_to_update);

//        if (!addressRepoImpl.updateAddress(employee.getAddress()))
//            throw new AddressNotFoundException(not_found_address_to_update);
    }

    @Override
    public void remove(int id) {
        if (!employeeRepoImpl.deleteEmployee(id)) {
            throw new EmployeeNotFoundException(not_found_employee_to_delete);
        }
    }

    @Override
    public RepresentationModel<EmployeeDTO> getEmployeeById(int id) {
        Optional<Employee> employee = employeeRepoImpl.findEmployeeById(id);
        if (!employee.isPresent()) {
            throw new EmployeeNotFoundException(not_found_employee_to_search);
        }

        Link link = linkTo(methodOn(this.getClass()).getAllEmployee())
                .slash(employee_uri)
                .withRel("employees");
        RepresentationModel<EmployeeDTO> representationModel = employeeMapper.ConvertEntityToEmployeeDTO(employee).add(link);
        return representationModel;
    }

    @Override
    public List<EmployeeDTO> getPagingEmployee(int pageNumber, int pageSize) {
        List<Employee> employees = employeeRepoImpl.findPagingEmployee(pageNumber, pageSize, "empId");
        if (employees.isEmpty()) {
            throw new UserNotFoundException(not_found_employee_to_paging);
        }
        return employeeMapper.convertEntityListToDTO(employees);    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        List<Employee> employees = employeeRepoImpl.findAllEmployees();
        if (employees.isEmpty()) {
            throw new UserNotFoundException(not_found_employee);
        }
        return employeeMapper.convertEntityListToDTO(employees);
    }

    @Override
    public List<EmployeeDTO> findEmpByType(boolean type) {
        List<Employee> employees = employeeRepoImpl.findEmpByType(type);
        if (employees.isEmpty() && type==false) {
            throw new UserNotFoundException(not_found_employee);
        }else if (employees.isEmpty() && type) {
            throw new UserNotFoundException(not_found_employee_admin);
        }
        return employeeMapper.convertEntityListToDTO(employees);
    }

    @Override
    public List<EmployeeDTO> findEmpByTypeAndId(boolean type, int id) {
        List<Employee> employees = employeeRepoImpl.findEmpByTypeAndId(type,id);
        if (employees.isEmpty() && type==false) {
            throw new UserNotFoundException(not_found_employee);
        }else if (employees.isEmpty() && type) {
            throw new UserNotFoundException(not_found_employee_admin);
        }
        return employeeMapper.convertEntityListToDTO(employees);
    }

    @Override
    public void updateEmpByTypeAndId( int id,boolean eType) {

        if (!employeeRepoImpl.updateEmpByTypeAndId(id,eType)) {
            throw new EmployeeNotFoundException(not_found_employee_to_update);
        }
    }
}
