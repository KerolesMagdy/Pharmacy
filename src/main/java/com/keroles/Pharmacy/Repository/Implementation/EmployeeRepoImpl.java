package com.keroles.Pharmacy.Repository.Implementation;

import com.keroles.Pharmacy.Model.Entity.Employee;
import com.keroles.Pharmacy.Repository.Operation.EmployeeJpaRepo;
import com.keroles.Pharmacy.Repository.Operation.EmployeeRepoOp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeRepoImpl implements EmployeeRepoOp {
    @Autowired
    EmployeeJpaRepo employeeJpaRepo;

    @Override
    public Employee insertEmployee(Employee employee) {
        return employeeJpaRepo.save(employee);
    }

    @Override
    public boolean updateEmployeeBasicInfo(Employee updatedEmployee) {
        try {
            Optional<Employee> searchEmployee = findEmployeeById(updatedEmployee.getEmpId());
            if (!searchEmployee.isPresent()) {
                return false;
            }
            Employee existEmployee=searchEmployee.get();
            existEmployee.Transfer(updatedEmployee);
            employeeJpaRepo.save(existEmployee);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteEmployee(int id) {
        if (!employeeJpaRepo.existsById(id)) {
            return false;
        } else {
            employeeJpaRepo.deleteById(id);
            return true;
        }
    }

    @Override
    public Optional<Employee> findEmployeeById(int id) {
        Optional<Employee> employee = employeeJpaRepo.findById(id);

        return employee;
    }

    @Override
    public List<Employee> findPagingEmployee(int pageNumber, int pageSize, String sortField) {
        Page<Employee> employees = employeeJpaRepo.findAll(new PageRequest(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, sortField)) {
        });
        return employees.getContent();
    }

    @Override
    public List<Employee> findAllEmployees() {
        List<Employee> employees = employeeJpaRepo.findAll();
        return employees;
    }

    @Override
    public List<Employee> findEmpByType(boolean type) {
        return employeeJpaRepo.findEmpByType(type);
    }

    @Override
    public List<Employee> findEmpByTypeAndId(boolean type, int id) {
        return employeeJpaRepo.findEmpByTypeAndId(type,id);
    }

    @Override
    public boolean updateEmpByTypeAndId(int id, boolean type) {
        try {
            Optional<Employee> searchEmployee = findEmployeeById(id);
            if (!searchEmployee.isPresent()) {
                return false;
            }
            employeeJpaRepo.updateEmpByTypeAndId(id,type);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
