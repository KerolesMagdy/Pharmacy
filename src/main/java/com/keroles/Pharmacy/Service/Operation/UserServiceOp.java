/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keroles.Pharmacy.Service.Operation;

import com.keroles.Pharmacy.DTO.Model.UserDTO;
import com.keroles.Pharmacy.Model.Entity.Users;
import java.util.List;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Keroles Magdy
 */
public interface UserServiceOp {

    UserDTO save(Users user);

    void updateBasicInfo(Users user);

    void remove(int id);

    RepresentationModel<UserDTO> getUserById(int id);

    List<UserDTO> getPagingUser(int pageNumber, int pageSize);

    List<UserDTO> getAllUsers();

}
