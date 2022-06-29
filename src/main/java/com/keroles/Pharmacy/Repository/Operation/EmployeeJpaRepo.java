package com.keroles.Pharmacy.Repository.Operation;

import com.keroles.Pharmacy.Model.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeJpaRepo extends JpaRepository<Employee,Integer> {

    @Query("select e from Employee e where e.empType = :type")
    List<Employee> findEmpByType(boolean type);

    @Query("select e from Employee e where e.empType = :type and e.empId= :id")
    List<Employee> findEmpByTypeAndId(boolean type, int id);

    @Modifying
    @Query("update Employee e set e.empType= :type where e.empId = :id")
    void updateEmpByTypeAndId(int id,boolean type);
}
