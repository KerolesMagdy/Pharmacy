/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keroles.Pharmacy.DTO.Model;

import java.io.Serializable;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

/**
 *
 * @author Keroles Magdy
 */
@Data
public class AddressDTO extends RepresentationModel<AddressDTO> implements Serializable {
     private Integer addressId;
     private String addressTitle;
     private String city;
     private String governorate;
}
