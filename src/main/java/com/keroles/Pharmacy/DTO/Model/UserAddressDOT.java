/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keroles.Pharmacy.DTO.Model;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Keroles Magdy
 */
@Data
public class UserAddressDOT implements Serializable {
     private Integer addressId;
     private String addressTitle;
     private String city;
     private String governorate;
}
