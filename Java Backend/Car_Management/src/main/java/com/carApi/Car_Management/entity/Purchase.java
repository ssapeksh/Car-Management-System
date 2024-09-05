package com.carApi.Car_Management.entity;

import jakarta.persistence.*;
import java.util.Date;

//import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CarId")
    //@JsonIgnore
    private Car car;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UserId")
    //@JsonIgnore
    private User user;

    @Column(name = "purchase_date")
    private Date purchaseDate;

    @Column(name = "price")
    private double price;

    // Constructors, Getters, Setters
    public Purchase() {}

    public Purchase(Car car, User user, Date purchaseDate, double price) {
        this.car = car;
        this.user = user;
        this.purchaseDate = purchaseDate;
        this.price = price;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

    // Getters and Setters
    // ...
}
