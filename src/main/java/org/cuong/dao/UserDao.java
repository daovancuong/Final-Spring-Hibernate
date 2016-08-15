package org.cuong.dao;

/**
 *@author CSE
 *@version 1.0 Aug 13, 2016
 */
import java.util.List;

import org.cuong.model.Users;

public interface UserDao {
    
    List<Users> findAllUsers();
    
    Users createUser(Users users);
    
    Users findById(String id);
    
    void delete(String id );
    
    Users update(Users users);
    
    Users findByEmail(String email);
    
}
