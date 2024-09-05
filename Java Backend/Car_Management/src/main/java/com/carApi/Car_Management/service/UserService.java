package com.carApi.Car_Management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.carApi.Car_Management.entity.User;
//import com.carApi.Car_Management.entity.UserDto;
import com.carApi.Car_Management.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepositoryRef;
	
	@Autowired
    //private PasswordEncoder passwordEncoder;
	
	public List<User> getAllUsers(){
		return userRepositoryRef.findAll();
	}
	
	public User getUserById(Integer id) {
		Optional<User> optionalUser=userRepositoryRef.findById(id);
		return optionalUser.orElse(null);
	}
	
	public User createuser(User user)
	{
		return userRepositoryRef.save(user);
	}
	
	public void deleteuser(Integer id)
	{
		 userRepositoryRef.deleteById(id);
	}
	
	
	
	
	
	
	
}

