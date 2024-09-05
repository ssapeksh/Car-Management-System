package com.carApi.Car_Management.entity;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CarDetails")
@CrossOrigin(origins = "http://localhost:3000") // Adjust as necessary
public class Car {
	
	@Id
	@Column(name="CarId")
	private int CarId;
	
	@Column(name="CarName")
	private String CarName;
	
	@Column(name="CarModel")
	private String CarModel;
	
	@Column(name="Brand")
	private String Brand;
	
	@Column(name="Price")
	private double Price;
	
	@Column(name="Available")
	private boolean Available;
	
	@Column(name="Status")
	private String Status ;    //Booked,Available,Aquired

	public int getCar_id() {
		return CarId;
	}

	public void setCar_id(int CarId) {
		this.CarId = CarId;
	}

	public String getCar_name() {
		return CarName;
	}

	public void setCar_name(String CarName) {
		this.CarName = CarName;
	}

	public String getCar_model() {
		return CarModel;
	}

	public void setCar_model(String CarModel) {
		this.CarModel = CarModel;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String Brand) {
		this.Brand = Brand;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double Price) {
		this.Price = Price;
	}

	public boolean isAvailable() {
		return Available;
	}

	public void setAvailable(boolean Available) {
		this.Available = Available;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String Status) {
		this.Status = Status;
	}

	public Car(int CarId, String CarName, String CarModel, String Brand, double Price, boolean Available,
			String Status) {
		
		this.CarId = CarId;
		this.CarName = CarName;
		this.CarModel = CarModel;
		this.Brand = Brand;
		this.Price = Price;
		this.Available = Available;
		this.Status = Status;
	}

	public Car() {
		
	}

	@Override
	public String toString() {
		return "Car [CarId=" + CarId + ", CarName=" + CarName + ", CarModel=" + CarModel + ", Brand=" + Brand
				+ ", Price=" + Price + ", Available=" + Available + ", status=" + Status + "]";
	}

	// Constructors, Getters, Setters, toString() method
	
	
}
