package com.niit.UserServiceImpl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.CRUDhibernatedao.UserDao;
import com.niit.CRUDhibernatemodel.User;
import com.niit.UserService.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	
	public boolean addUser(User user) {
		userDao.addUser(user);
		return false;
	}
	

	public User getUserById(int userId) {
		return userDao.getUserById(userId);
		
	}
	

	public List<User> getuserList() {
		return userDao.getuserList();
		
	}
	
	
	public boolean updateUser(User user) {
		userDao.updateUser(user);
		return true;
	}


	public boolean deleteUser(User user) {
		userDao.deleteUser(user);
		return true;
	}


	public User getByUsername(String username) {
	return userDao.getByUsername(username);
	
	}
	
	

}
