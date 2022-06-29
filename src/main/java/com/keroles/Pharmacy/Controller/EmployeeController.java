package com.keroles.Pharmacy.Controller;

import com.keroles.Pharmacy.DTO.Model.EmployeeDTO;
import com.keroles.Pharmacy.Model.Entity.Employee;
import com.keroles.Pharmacy.Service.Implementation.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.keroles.Pharmacy.Constant.ConstantURI.*;

@RestController
@Transactional
@RequestMapping(employee_uri)
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @RequestMapping( method = RequestMethod.POST)
    public EmployeeDTO addEmployee(@Valid @RequestBody Employee employee) {
        return employeeServiceImpl.save(employee);
    }

    @RequestMapping( method = RequestMethod.PUT)
    public void updateEmployee(@RequestBody Employee employee) {
        employeeServiceImpl.updateBasicInfo(employee);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void removeEmployee(@PathVariable("id") Integer empId) {
        employeeServiceImpl.remove(empId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public RepresentationModel<EmployeeDTO> findEmployeeById(@PathVariable("id") Integer empId) {
        return employeeServiceImpl.getEmployeeById(empId);
    }

    @RequestMapping(value = page_uri, method = RequestMethod.GET)
    public List<EmployeeDTO> findPagingEmployee(@RequestParam int pageNumber, @RequestParam int pageSize) {
        return employeeServiceImpl.getPagingEmployee(pageNumber, pageSize);
    }

    @RequestMapping( method = RequestMethod.GET)
    public List<EmployeeDTO> getAllEmployee() {
        return employeeServiceImpl.getAllEmployee();
    }

    @RequestMapping( value =employee_type_uri, method = RequestMethod.POST)
    public List<EmployeeDTO> getAllEmpByType(@RequestParam boolean eType) {
        return employeeServiceImpl.findEmpByType(eType);
    }

//    @RequestMapping( value =employee_type_id_uri, method = RequestMethod.POST)
//    public List<EmployeeDTO> getEmpByTypeAndId(@RequestParam boolean eType,@RequestParam int id) {
//        return employeeServiceImpl.findEmpByTypeAndId(eType,id);
//    }

    @RequestMapping(value =employee_type_id_uri, method = RequestMethod.PUT)
    public void updateEmpByTypeAndId(@RequestParam int empId,@RequestParam boolean eType) {
        employeeServiceImpl.updateEmpByTypeAndId(empId,eType);
    }

}
