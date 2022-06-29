/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keroles.Pharmacy.Repository.Operation;

import com.keroles.Pharmacy.DTO.Model.UserDTO;
import com.keroles.Pharmacy.Model.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Keroles Magdy
 */
@Repository
public interface UserJpaRepo extends JpaRepository<Users, Integer> {
}
