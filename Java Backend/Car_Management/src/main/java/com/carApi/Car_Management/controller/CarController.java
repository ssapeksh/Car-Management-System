package com.carApi.Car_Management.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import com.carApi.Car_Management.entity.Car;
import com.carApi.Car_Management.service.CarService;

@RestController
public class CarController {

	@Autowired
	private CarService carserviceref;
	
	@GetMapping("/api/GetAllCars")
	public Collection<Car> GetAllCars()
	{
		Collection<Car> getallcars = carserviceref.GelAllCars();
		return getallcars;
	}
	
	@GetMapping("/api/GetOneCar/{id}")
	public Car GetOneCar(@PathVariable Integer id)
	{
		return carserviceref.GetOneCar(id);
	}
	
	
	
	@GetMapping("/api/GetCarByName/{name}")
	public Collection<Car> GetCarByName(@PathVariable String name)
	{
		return carserviceref.GetCarByName(name);
	}
	
	
	
	
	
	
	
	
	
}
