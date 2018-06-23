package com.niit.UserService;

import java.util.List;

import com.niit.CRUDhibernatemodel.User;

public interface UserService {

	
	public boolean addUser(User user);
	public User getUserById(int userId);
	public List<User> getuserList();
	public boolean updateUser(User user);
	public boolean deleteUser(User user);
	public User getByUsername(String username);
}
