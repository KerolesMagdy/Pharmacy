/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keroles.Pharmacy.Repository.Implementation;

import com.keroles.Pharmacy.Model.Entity.Users;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.StaleObjectStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.keroles.Pharmacy.Repository.Operation.UserJpaRepo;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import com.keroles.Pharmacy.Repository.Operation.UserRepoOp;
import org.springframework.data.domain.Page;

@Repository
@Transactional(rollbackFor = StaleObjectStateException.class)
@Component

public class UserRepoImpl implements UserRepoOp {

    @Autowired
    private EntityManager entityManager;
    @Autowired
    private UserJpaRepo userJpaRepo;

    @Override
    public Users insertUser(Users user) {
        return userJpaRepo.save(user);

        /*      Session currentSession = entityManager.unwrap(Session.class);
        currentSession.save(user);
        return user;
         */

 /* Users findUsers = null;
        try {
            //Query query = mgr.createQuery("SELECT u FROM User u WHERE u.email = '" + email + "'");
            Query query = entityManager.createQuery("SELECT FROM users u WHERE u.USER_EMAIL = :email");
            query.setParameter("email", user.getUserEmail());
            findUsers = (Users) query.getSingleResult();
        } finally {
            entityManager.close();
        }
        if (findUsers != null) {
            currentSession.save(user);
            return user;
        }else 
            return null;
         */
    }

    @Override
    public boolean updateUserBasicInfo(Users updatedUser) {
        try {
            Optional<Users> searchUser = findUserById(updatedUser.getUserId());
            if (!searchUser.isPresent()) {
                return false;
            }
            Users existUser=searchUser.get();
            existUser.Transfer(updatedUser);
            userJpaRepo.save(existUser);
        } catch (Exception e) {
            return false;
        }
        return true;
        /*
        Session currentSession = entityManager.unwrap(Session.class);
        if (findUserById(updatedUser.getUserId()) == null) {
            return false;
        }
        currentSession.clear();
        currentSession.saveOrUpdate(updatedUser);
        return true;
         */    }

    @Override
    public boolean deleteUser(int id) {

        if (!userJpaRepo.existsById(id)) {
            return false;
        } else {
            userJpaRepo.deleteById(id);
            return true;
        }
        /*        Session currentSession = entityManager.unwrap(Session.class);
        Users user = currentSession.find(Users.class, id);
        if (user == null) {
            return false;
        } else {
            currentSession.remove(user);
            return true;
        }
         */
    }

    @Override
    public Optional<Users> findUserById(int id) {

        /*   Session currentSession = entityManager.unwrap(Session.class);
        Users user = currentSession.find(Users.class, id);
         return user;
         */
        Optional<Users> user = userJpaRepo.findById(id);

        return user;
    }

    @Override
    public List<Users> findPagingUser(int pageNumber, int pageSize, String sortField) {
        Page<Users> userses = userJpaRepo.findAll(new PageRequest(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, sortField)) {
        });

        /*        Query query = entityManager.createQuery("From Users");
        query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);
        List<Users> users = query.getResultList();
        return users;
         */
        return userses.getContent();
    }

    @Override
    public List<Users> findAllUsers() {

        /* Query query = entityManager.createQuery("From Users");
        List<Users> users = query.getResultList();
        return users;
         */
        List<Users> users = userJpaRepo.findAll();
        return users;
    }

}
