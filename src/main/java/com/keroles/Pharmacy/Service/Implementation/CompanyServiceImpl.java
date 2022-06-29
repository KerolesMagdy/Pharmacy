package com.keroles.Pharmacy.Service.Implementation;

import com.keroles.Pharmacy.DTO.Mapper.CompanyMapper;
import com.keroles.Pharmacy.DTO.Model.CompanyDTO;
import com.keroles.Pharmacy.Exception.Exceptions.CompanyNotFoundException;
import com.keroles.Pharmacy.Exception.Exceptions.EmployeeNotFoundException;
import com.keroles.Pharmacy.Exception.Exceptions.UserNotFoundException;
import com.keroles.Pharmacy.Model.Entity.Company;
import com.keroles.Pharmacy.Repository.Implementation.AddressRepoImpl;
import com.keroles.Pharmacy.Repository.Implementation.CompanyRepoImpl;
import com.keroles.Pharmacy.Service.Operation.CompanyServiceOp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static com.keroles.Pharmacy.Constant.ConstantExceptionPhrases.*;
import static com.keroles.Pharmacy.Constant.ConstantURI.company_uri;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class CompanyServiceImpl implements CompanyServiceOp {

    @Autowired
    CompanyRepoImpl companyRepoImpl;
    @Autowired
    AddressRepoImpl addressRepoImpl;
    @Autowired
    CompanyMapper companyMapper;

    @Override
    public CompanyDTO save(Company company) {
        if (addressRepoImpl.insertAddress(company.getAddress()) != null) {
            return companyMapper.convertEntityToDTO(companyRepoImpl.insertCompany(company));
        } else {
            return null;
        }
    }

    @Override
    public void updateCompany(Company updatedCompany) {
        if (!companyRepoImpl.updateCompany(updatedCompany)) {
            throw new CompanyNotFoundException(not_found_company_to_update);
        }
    }

    @Override
    public void removeCompany(int id) {
        if (!companyRepoImpl.deleteCompany(id)) {
            throw new EmployeeNotFoundException(not_found_company_to_delete);
        }
    }

    @Override
    public RepresentationModel<CompanyDTO> getCompanyById(int id) {
        Optional<Company> company = companyRepoImpl.findCompanyById(id);
        if (!company.isPresent()) {
            throw new EmployeeNotFoundException(not_found_company_to_search);
        }

        Link link = linkTo(methodOn(this.getClass()).getAllCompanies())
                .slash(company_uri)
                .withRel("companies");
        RepresentationModel<CompanyDTO> representationModel = companyMapper.convertEntityToDTO(company).add(link);
        return representationModel;
    }

    @Override
    public List<CompanyDTO> getPagingCompany(int pageNumber, int pageSize) {
        List<Company> companies = companyRepoImpl.findPagingCompany(pageNumber, pageSize, "companyId");
        if (companies.isEmpty()) {
            throw new UserNotFoundException(not_found_company_to_paging);
        }
        return companyMapper.convertEntityListToDTO(companies);        }

    @Override
    public List<CompanyDTO> getAllCompanies() {
        List<Company> companies = companyRepoImpl.findAllCompanies();
        if (companies.isEmpty()) {
            throw new UserNotFoundException(not_found_company);
        }
        return companyMapper.convertEntityListToDTO(companies);
    }

    @Override
    public List<CompanyDTO> getCompanyByName(String name) {
        List<Company> companies = companyRepoImpl.findCompanyByName(name);
        if (companies.isEmpty()) {
            throw new UserNotFoundException(not_found_company);
        }
        return companyMapper.convertEntityListToDTO(companies);    }
}
