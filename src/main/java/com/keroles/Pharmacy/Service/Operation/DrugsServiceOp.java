package com.keroles.Pharmacy.Service.Operation;

import com.keroles.Pharmacy.DTO.Model.DeliveryManDTO;
import com.keroles.Pharmacy.DTO.Model.DrugsDTO;
import com.keroles.Pharmacy.Model.Entity.DeliveryMan;
import com.keroles.Pharmacy.Model.Entity.Drugs;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

public interface DrugsServiceOp {

    DrugsDTO save(Drugs drugs);

    void updateDrugs(Drugs updatedDrugs);

    void removeDrugs(String id);

    RepresentationModel<DrugsDTO> getDrugsById(String id);

    List<DrugsDTO> getPagingDrugs(int pageNumber, int pageSize);

    List<DrugsDTO> getAllDrugs();

    List<DrugsDTO> getDrugsByName(String drugsName);
}
