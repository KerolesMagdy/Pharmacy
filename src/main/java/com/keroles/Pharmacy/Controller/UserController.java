/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keroles.Pharmacy.Controller;

import com.keroles.Pharmacy.DTO.Model.UserDTO;
import com.keroles.Pharmacy.Model.Entity.Users;
import com.keroles.Pharmacy.Service.Implementation.UserServiceImpl;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.validation.Valid;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import static com.keroles.Pharmacy.Constant.ConstantURI.*;


@RestController()
@RequestMapping(user_uri)
public class UserController {

    @Autowired
    UserServiceImpl adminServiceImpl;

    @Autowired
    ServletContext context;

    @RequestMapping( method = RequestMethod.POST)
    public UserDTO addUser(@Valid@RequestBody Users user) {
        return adminServiceImpl.save(user);
    }

    @RequestMapping( method = RequestMethod.PUT)
    public void updateUser(@RequestBody Users user) {
         adminServiceImpl.updateBasicInfo(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void removeUser(@PathVariable("id") Integer id) {
        adminServiceImpl.remove(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public RepresentationModel<UserDTO> findUserById(@PathVariable("id") Integer userId) {      
        return adminServiceImpl.getUserById(userId);
    }

    @RequestMapping(value = page_user_uri, method = RequestMethod.GET)
    public List<UserDTO> findPagingUsers(@RequestParam int pageNumber, @RequestParam int pageSize) {
        return adminServiceImpl.getPagingUser(pageNumber, pageSize);
    }

    @RequestMapping( method = RequestMethod.GET)
    public List<UserDTO> getAllUsers() {
        return adminServiceImpl.getAllUsers();
    }
}