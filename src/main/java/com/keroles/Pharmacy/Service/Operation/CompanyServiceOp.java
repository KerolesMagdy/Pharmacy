package com.keroles.Pharmacy.Service.Operation;

import com.keroles.Pharmacy.DTO.Model.CompanyDTO;
import com.keroles.Pharmacy.Model.Entity.Company;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

public interface CompanyServiceOp {
    CompanyDTO save(Company company);

    void updateCompany(Company updatedCompany);

    void removeCompany(int id);

    RepresentationModel<CompanyDTO> getCompanyById(int id);

    List<CompanyDTO> getPagingCompany(int pageNumber, int pageSize);

    List<CompanyDTO> getAllCompanies();

    List<CompanyDTO> getCompanyByName(String name);
}
