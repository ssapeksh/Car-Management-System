package com.carApi.Car_Management.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Rental")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CarId")
    private Car car;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UseId")
    private User user;

    @Column(name = "rental_date")
    private Date rentalDate;

    @Column(name = "return_date")
    private Date returnDate;

    @Column(name = "total_price")
    private double totalPrice;

    // Constructors, Getters, Setters
    public Rental() {}

    public Rental(Car car, User user, Date rentalDate, Date returnDate, double totalPrice) {
        this.car = car;
        this.user = user;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.totalPrice = totalPrice;
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

	public Date getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Rental [id=" + id + ", car=" + car + ", user=" + user + ", rentalDate=" + rentalDate + ", returnDate="
				+ returnDate + ", totalPrice=" + totalPrice + "]";
	}

    // Getters and Setters
    // ...
    
}
