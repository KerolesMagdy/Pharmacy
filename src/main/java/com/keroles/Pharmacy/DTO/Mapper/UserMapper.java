/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keroles.Pharmacy.DTO.Mapper;

import com.keroles.Pharmacy.DTO.Model.UserDTO;
import com.keroles.Pharmacy.Model.Entity.Users;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Keroles Magdy
 */
@Component
public class UserMapper {
    
    @Autowired 
    private AddressMapper addressMapper;
    
    public UserDTO convertEntityToDTO(Users users){
        UserDTO userDTO=new UserDTO();
        userDTO.setUserId(users.getUserId());
        userDTO.setUserPhone(users.getUserPhone());
        userDTO.setUserImage(users.getUserImage());
        userDTO.setUserDob(users.getUserDob());
        userDTO.setUserEmail(users.getUserEmail());
        userDTO.setUserName(users.getUserName());
        userDTO.setUserLat(users.getUserLat());
        userDTO.setUserLong(users.getUserLong());
        userDTO.setAddressDTO(addressMapper.ConvertEntityToUserAddressDOT(users.getAddress()));
        return userDTO;
    }
    public UserDTO convertEntityToDTO(Optional<Users> users){
        UserDTO userDTO=new UserDTO();
        userDTO.setUserId(users.get().getUserId());
        userDTO.setUserPhone(users.get().getUserPhone());
        userDTO.setUserImage(users.get().getUserImage());
        userDTO.setUserDob(users.get().getUserDob());
        userDTO.setUserEmail(users.get().getUserEmail());
        userDTO.setUserName(users.get().getUserName());
        userDTO.setUserLat(users.get().getUserLat());
        userDTO.setUserLong(users.get().getUserLong());
        userDTO.setAddressDTO(addressMapper.ConvertEntityToUserAddressDOT(users.get().getAddress()));
        return userDTO;
    }
    public List<UserDTO>convertEntityListToDTO(List<Users> users){
        List  usersDTO= new ArrayList() ;
        for (Users u:users){
            usersDTO.add(convertEntityToDTO(u));
        }
        return usersDTO;
    }
}
