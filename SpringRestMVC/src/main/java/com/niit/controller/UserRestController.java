package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.CRUDhibernatemodel.User;
import com.niit.UserService.UserService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class UserRestController {

	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public ResponseEntity<List<User>> getUserList() {
		userService.getuserList();
		return new ResponseEntity<List<User>>(userService.getuserList(),HttpStatus.OK);		
	}
	
	@PostMapping()
	public ResponseEntity <Void> addUser(@RequestBody User user){
		
		userService.addUser(user);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity <User> getUserById(@PathVariable("userId") int userId){
		return new ResponseEntity<User>(userService.getUserById(userId),HttpStatus.OK);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity <Void> deleteUser(@PathVariable("userId") int userId){
		User user=userService.getUserById(userId);
		userService.deleteUser(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
		
		@PutMapping("/")
		public ResponseEntity<Void> updateUser(@RequestBody User user) {
		
		userService.updateUser(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
		}
		
		@PostMapping("/user")
		public ResponseEntity <User> getUserByUsername(@RequestBody User user){
			return new ResponseEntity<User>(userService.getByUsername(user.getUsername()),HttpStatus.OK);
		}
	}
	

