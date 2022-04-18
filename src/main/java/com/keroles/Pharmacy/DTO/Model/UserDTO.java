/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keroles.Pharmacy.DTO.Model;

import com.keroles.Pharmacy.Model.Entity.Address;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

/**
 *
 * @author Keroles Magdy
 */
@Data
public class UserDTO extends RepresentationModel<UserDTO> implements Serializable {

    int userId;
    String userName;
    int userPhone;
    String userEmail;
    String userImage;
    Date userDob;
    Float userLat;
    Float userLong;
    UserAddressDOT address;
}
