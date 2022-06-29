package com.keroles.Pharmacy.Repository.Operation;

import com.keroles.Pharmacy.Model.Entity.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyRepoOp {

    Company insertCompany(Company company);

    boolean updateCompany(Company updatedCompany);

    boolean deleteCompany(int id);

    Optional<Company> findCompanyById(int id);

    List<Company> findPagingCompany(int pageNumber, int pageSize, String sortField);

    List<Company> findAllCompanies();

    List<Company> findCompanyByName(String name);
}
