/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keroles.Pharmacy.Repository.Operation;

import com.keroles.Pharmacy.Model.Entity.Users;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Keroles Magdy
 */
public interface UserRepoOp {

    public Users insertUser(Users user);

    public boolean updateUserBasicInfo(Users user);

    public boolean deleteUser(int id);

    public Optional<Users> findUserById(int id);

    public List<Users> findPagingUser(int pageNumber, int pageSize,String sortField);

    public List<Users> findAllUsers();

    

}
