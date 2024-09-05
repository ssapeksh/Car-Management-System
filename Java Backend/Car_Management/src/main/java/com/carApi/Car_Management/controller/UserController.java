package com.carApi.Car_Management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.carApi.Car_Management.entity.User;
//import com.carApi.Car_Management.entity.UserDto;
import com.carApi.Car_Management.service.UserService;



@CrossOrigin
@RestController
public class UserController {

	@Autowired
	private UserService userServiceRef;
	
	@GetMapping("/api/users")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users=userServiceRef.getAllUsers();
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	@GetMapping("/api/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id){
		User user=userServiceRef.getUserById(id);
		if(user!=null) {
			return new ResponseEntity<>(user,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
//	@PostMapping("/api/createuser")
//	public User createuser(@RequestBody User user)
//	{
//		return userServiceRef.createuser(user);
//	}
	
	@PostMapping("/api/createuser")
	public User createuser(@RequestBody User user) {
	    System.out.println("Received User: " + user);
	    return userServiceRef.createuser(user);
	}

	
	
	@DeleteMapping("/api/user/delete/{id}")
	public void deleteuser(@PathVariable Integer id)
	{
		userServiceRef.deleteuser(id);
	}
	
	
	
}
