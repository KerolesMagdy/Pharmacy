/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keroles.Pharmacy.Service.Implementation;

import com.keroles.Pharmacy.DTO.Model.UserDTO;
import com.keroles.Pharmacy.Exception.Exceptions.AddressNotFoundException;
import com.keroles.Pharmacy.Exception.Exceptions.EmployeeNotFoundException;
import com.keroles.Pharmacy.Exception.Exceptions.UserNotFoundException;
import com.keroles.Pharmacy.DTO.Mapper.UserMapper;
import com.keroles.Pharmacy.Model.Entity.Users;
import com.keroles.Pharmacy.Repository.Implementation.AddressRepoImpl;
import com.keroles.Pharmacy.Repository.Implementation.UserRepoImpl;
import com.keroles.Pharmacy.Service.Operation.UserServiceOp;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.stereotype.Component;
import static com.keroles.Pharmacy.Constant.ConstantExceptionPhrases.*;
import static com.keroles.Pharmacy.Constant.ConstantURI.*;

/**
 *
 * @author Keroles Magdy
 */
@Component
public class UserServiceImpl implements UserServiceOp {

    @Autowired
    private UserRepoImpl userRepoImpl;
    @Autowired
    private AddressRepoImpl addressRepoImpl;
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO save(Users user) {
        if (addressRepoImpl.insertAddress(user.getAddress()) != null) {
            return userMapper.convertEntityToDTO(userRepoImpl.insertUser(user));
        } else {
            return null;
        }
    }

    @Override
    public void updateBasicInfo(Users user) {
        if (!userRepoImpl.updateUserBasicInfo(user))
            throw new UserNotFoundException(not_found_user_to_update);

//        if (!addressRepoImpl.updateAddress(user.getAddress()))
//            throw new AddressNotFoundException(not_found_address_to_update);
    }

    @Override
    public void remove(int id) {
        if (!userRepoImpl.deleteUser(id)) {
            throw new UserNotFoundException(not_found_user_to_delete);
        }
    }

    @Override
    public RepresentationModel<UserDTO> getUserById(int id) {
        Optional<Users> user = userRepoImpl.findUserById(id);
        if (!user.isPresent()) {
            throw new UserNotFoundException(not_found_user_to_search);
        }

        Link link = linkTo(methodOn(this.getClass()).getAllUsers())
                .slash(user_uri)
                .withRel("users");
        RepresentationModel<UserDTO> representationModel = userMapper.convertEntityToDTO(user).add(link);
        return representationModel;
    }

    @Override
    public List<UserDTO> getPagingUser(int pageNumber, int pageSize) {
        List<Users> users = userRepoImpl.findPagingUser(pageNumber, pageSize, "userId");
        if (users.isEmpty()) {
            throw new UserNotFoundException(not_found_user_to_paging);
        }
        return userMapper.convertEntityListToDTO(users);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<Users> users = userRepoImpl.findAllUsers();
        if (users.isEmpty()) {
            throw new UserNotFoundException(not_found_users);
        }
        return userMapper.convertEntityListToDTO(users);
    }
}
