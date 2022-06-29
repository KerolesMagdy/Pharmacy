package com.keroles.Pharmacy.Controller;

import com.keroles.Pharmacy.DTO.Model.CompanyDTO;
import com.keroles.Pharmacy.Model.Entity.Company;
import com.keroles.Pharmacy.Service.Implementation.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

import static com.keroles.Pharmacy.Constant.ConstantURI.*;

@RestController
@RequestMapping(company_uri)
public class CompanyController {

    @Autowired
    CompanyServiceImpl companyServiceImpl;

    @RequestMapping( method = RequestMethod.POST)
    public CompanyDTO addCompany(@Valid @RequestBody Company company) {
        return companyServiceImpl.save(company);
    }

    @RequestMapping( method = RequestMethod.PUT)
    public void updateCompany(@RequestBody Company company) {
        companyServiceImpl.updateCompany(company);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void removeCompany(@PathVariable("id") Integer id) {
        companyServiceImpl.removeCompany(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public RepresentationModel<CompanyDTO> findCompanyById(@PathVariable("id") Integer id) {
        return companyServiceImpl.getCompanyById(id);
    }

    @RequestMapping(value = page_uri, method = RequestMethod.GET)
    public List<CompanyDTO> findPagingCompany(@RequestParam int pageNumber, @RequestParam int pageSize) {
        return companyServiceImpl.getPagingCompany(pageNumber, pageSize);
    }

    @RequestMapping( method = RequestMethod.GET)
    public List<CompanyDTO> getAllCompany() {
        return companyServiceImpl.getAllCompanies();
    }

    @RequestMapping(value = company_name_uri, method = RequestMethod.GET)
    public List<CompanyDTO> getAllCompanyByName(@RequestParam(value = "compName") String compName) {
        return companyServiceImpl.getCompanyByName(compName);
    }

}
