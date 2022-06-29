package com.keroles.Pharmacy.DTO.Mapper;

import com.keroles.Pharmacy.DTO.Model.CompanyDTO;
import com.keroles.Pharmacy.DTO.Model.UserDTO;
import com.keroles.Pharmacy.Model.Entity.Company;
import com.keroles.Pharmacy.Model.Entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CompanyMapper {

    @Autowired
    private AddressMapper addressMapper;
    public CompanyDTO convertEntityToDTO(Company company){
        CompanyDTO companyDTO=new CompanyDTO();
        companyDTO.setCompanyId(company.getCompanyId());
        companyDTO.setName(company.getName());
        companyDTO.setPhone(company.getPhone());
        companyDTO.setLogo(company.getLogo());
        companyDTO.setAddressDTO(addressMapper.ConvertEntityToUserAddressDOT(company.getAddress()));
        return companyDTO;
    }

  public CompanyDTO convertEntityToDTO(Optional<Company> company){
        CompanyDTO companyDTO=new CompanyDTO();
        companyDTO.setCompanyId(company.get().getCompanyId());
        companyDTO.setName(company.get().getName());
        companyDTO.setPhone(company.get().getPhone());
        companyDTO.setLogo(company.get().getLogo());
        companyDTO.setAddressDTO(addressMapper.ConvertEntityToUserAddressDOT(company.get().getAddress()));
        return companyDTO;
    }

    public List<CompanyDTO> convertEntityListToDTO(List<Company> companies){
        List  usersDTO= new ArrayList() ;
        for (Company c:companies){
            usersDTO.add(convertEntityToDTO(c));
        }
        return usersDTO;
    }

}
