package com.carApi.Car_Management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carApi.Car_Management.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	
}
