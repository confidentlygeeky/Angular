package com.niit.SpringHibCRUD.testcases;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.CRUDhibernatemodel.User;
import com.niit.UserService.UserService;
import com.niit.userconfiguration.UserConfig;

@RunWith(SpringRunner.class)

@SpringJUnitConfig(classes=UserConfig.class)

public class ServiceTest {
	
	@Autowired
	UserService userService;

	@SuppressWarnings("resource")
	@Before
	public void setUp() throws Exception {
		

		AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext();
		ctx.scan("com.niit");
		ctx.refresh();
	}

	@After
	public void tearDown() throws Exception {
		userService=null;
	}

	@Ignore
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Test
	public void getuserList() {
		List<User> getUserList = userService.getuserList();
		for(User user:getUserList) {
			System.out.println("Name: "+user.getUsername());
			System.out.println("Password: "+user.getPassword());
			System.out.println("Contact: "+user.getPhone_number());
		}
		assertEquals(getUserList.size() >0, userService.getuserList());
		
	}
	
	@Ignore
	@Test
	public void addUser() {
		User user=new User();
		user.setUsername("Kunaal");
		user.setPassword("pass123");
		user.setPhone_number("934123343");
		
		assertEquals(true, userService.addUser(user));
		
	}
	
	@Ignore
	@Test
	public void updateUser() {
		User user = userService.getUserById(4);
		user.setUsername("Kunaal");
		user.setPassword("@123");
		user.setPhone_number("9969684625");
		assertEquals(true, userService.updateUser(user));
	}
	
	@Ignore
	@Test
	public void deleteUser() {
		User user = userService.getUserById(1);
		assertEquals(true, userService.deleteUser(user));
	}
};

