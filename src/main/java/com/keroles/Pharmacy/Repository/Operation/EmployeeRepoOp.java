package com.keroles.Pharmacy.Repository.Operation;

import com.keroles.Pharmacy.Model.Entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepoOp {


    Employee insertEmployee(Employee employee);

    boolean updateEmployeeBasicInfo(Employee updatedEmployee);
    boolean deleteEmployee(int id);

    Optional<Employee> findEmployeeById(int id);

    List<Employee> findPagingEmployee(int pageNumber, int pageSize, String sortField);

    List<Employee> findAllEmployees();

    List<Employee> findEmpByType(boolean type);

    List<Employee> findEmpByTypeAndId(boolean type, int id);

    boolean updateEmpByTypeAndId(int id,boolean type);

}
