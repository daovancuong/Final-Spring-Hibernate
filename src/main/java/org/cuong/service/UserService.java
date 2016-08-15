package org.cuong.service;

import java.util.List;

import org.cuong.model.Users;

/**
 * @author CSE
 * @version 1.0 Aug 13, 2016
 */
public interface UserService {
    List<Users> findAllUsers();
    
    Users createUser(Users users);
    
    Users findById(String id);
    
    void delete(String id);
    
    Users update(Users users);
    Users findByEmail(String email);
}
