package com.carApi.Car_Management.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carApi.Car_Management.entity.Car;
//import com.carApi.Car_Management.entity.User;
import com.carApi.Car_Management.repository.CarRepository;

@Service
public class CarService {
	
	@Autowired
	private CarRepository carreporef;
	
	public Collection<Car> GelAllCars()
	{
		Collection<Car> allcars = carreporef.findAll();
		return allcars;
	}
	
	public Car GetOneCar(Integer id)
	{
		Car GetOneCar= null;
		Optional<Car> FoundedCar = carreporef.findById(id);
		if(FoundedCar.isPresent())
		{
			GetOneCar=FoundedCar.get();
		}
		return GetOneCar;
		
	}
	
	
	public Collection<Car> GetCarByName(String name)
	{
		//String name = car_name;
		//Collection<Car> foundedcar = ((CarService) carreporef).GetCarByName(name);
		//return foundedcar;
		
		return carreporef.GetCarByName(name);
	}
	
	public void savecar(Car car)
	{
		 carreporef.save(car);
	}
	
	

}
