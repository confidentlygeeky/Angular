package com.niit.CRUDhibernatedaoimpl;

import java.util.List;

import javax.transaction.Transactional;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.CRUDhibernatedao.UserDao;
import com.niit.CRUDhibernatemodel.User;


@Repository
@Transactional
public class UserDAOImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public boolean addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
		return true;
	}

	public User getUserById(int userId) {
		return (User) sessionFactory.getCurrentSession().createQuery("from User where userId = "+userId).uniqueResult();
		
	}

	@SuppressWarnings("unchecked")
	public List<User> getuserList() {
		return sessionFactory.getCurrentSession().createQuery("from User").getResultList();
	
	}


	public boolean updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
		return true;
	}

	public boolean  deleteUser(User user){
		sessionFactory.getCurrentSession().delete(user);
		return true;
		
	}

	public User getByUsername(String username) {
		return (User) sessionFactory.getCurrentSession().createQuery("from User where username ='"+username+"'").uniqueResult();
		
	}
	
	
	

}
