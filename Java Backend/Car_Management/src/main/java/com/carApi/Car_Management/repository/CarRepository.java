package com.carApi.Car_Management.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.carApi.Car_Management.entity.Car;

public interface CarRepository extends JpaRepository<Car, Integer>{

	@Query("SELECT c FROM Car c WHERE c.Brand = :name")
	public Collection<Car> GetCarByName(@Param("name") String name);
}
