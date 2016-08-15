package org.cuong.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.cuong.dao.UserDao;
import org.cuong.model.Users;
import org.cuong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author CSE
 * @version 1.0 Aug 13, 2016
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	public List<Users> findAllUsers() {
		return userDao.findAllUsers();
	}

	public Users createUser(Users users) {
		return userDao.createUser(users);
	}

	public Users findById(String id) {
		return userDao.findById(id);
	}

	public void delete(String id) {
		userDao.delete(id);
	}

	public Users update(Users users) {
		return userDao.update(users);
	}

	public Users findByEmail(String email) {
		return userDao.findByEmail(email);
	}

}
