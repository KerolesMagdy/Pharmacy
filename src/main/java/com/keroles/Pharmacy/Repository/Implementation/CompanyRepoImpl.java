package com.keroles.Pharmacy.Repository.Implementation;

import com.keroles.Pharmacy.Model.Entity.Company;
import com.keroles.Pharmacy.Model.Entity.Employee;
import com.keroles.Pharmacy.Repository.Operation.CompanyJpaRepo;
import com.keroles.Pharmacy.Repository.Operation.CompanyRepoOp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CompanyRepoImpl implements CompanyRepoOp {

    @Autowired
    CompanyJpaRepo companyJpaRepo;

    @Override
    public Company insertCompany(Company company) {
        return companyJpaRepo.save(company);
    }

    @Override
    public boolean updateCompany(Company updatedCompany) {
        try {
            Optional<Company> searchCompany = findCompanyById(updatedCompany.getCompanyId());
            if (!searchCompany.isPresent()) {
                return false;
            }
            Company existCompany=searchCompany.get();
            existCompany.Transfer(updatedCompany);
            companyJpaRepo.save(existCompany);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteCompany(int id) {

        if (!companyJpaRepo.existsById(id)) {
            return false;
        } else {
            companyJpaRepo.deleteById(id);
            return true;
        }
    }

    @Override
    public Optional<Company> findCompanyById(int id) {
        Optional<Company> company = companyJpaRepo.findById(id);
        return company;
    }

    @Override
    public List<Company> findPagingCompany(int pageNumber, int pageSize, String sortField) {
        Page<Company> companies = companyJpaRepo.findAll(new PageRequest(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, sortField)) {
        });
        return companies.getContent();
    }

    @Override
    public List<Company> findAllCompanies() {
        List<Company> companies = companyJpaRepo.findAll();
        return companies;
    }

    @Override
    public List<Company> findCompanyByName(String name) {
        return companyJpaRepo.findCompanyByName(name);
    }
}
