package org.cuong.dao.Impl;

import java.util.List;

import org.cuong.dao.UserDao;
import org.cuong.model.Users;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author CSE
 * @version 1.0 Aug 13, 2016
 */
@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;

	public List<Users> findAllUsers() {
		session = sessionFactory.getCurrentSession();
		return session.createCriteria(Users.class).list();
	}

	public Users createUser(Users users) {
		session = sessionFactory.getCurrentSession();
		session.persist(users);
		return users;
	}

	public Users findById(String id) {
		session = sessionFactory.getCurrentSession();
		return (Users) session.get(Users.class, id);
	}

	public void delete(String id) {
		session = sessionFactory.getCurrentSession();
		session.delete(findById(id));
	}

	public Users update(Users users) {
		session = sessionFactory.getCurrentSession();
		session.update(users);
		return users;
	}

	public Users findByEmail(String email) {
		session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Users.class);
		criteria.add(Restrictions.eq("email", email));
		return (Users) criteria.uniqueResult();
	}

}
