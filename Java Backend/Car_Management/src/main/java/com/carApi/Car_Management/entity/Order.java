package com.carApi.Car_Management.entity;

import java.util.Date;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="OrderDetails")
@CrossOrigin(origins = "http://localhost:3000") // Adjust as necessary
public class Order {
    @Id
    @Column(name = "OrderId")
    private int orderId;

    @Column(name="OrderDate")
    private Date orderDate;

    @Column(name = "Duration")
    private int durationDays;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "carId")
    private Car car;

    @Column(name="OrderStatus")
    private String status;  // cancelled, in process, completed 

    // Constructors, Getters, Setters, and toString() method
    public Order(int orderId, Date orderDate, int durationDays, User user, Car car, String status) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.durationDays = durationDays;
        this.user = user;
        this.car = car;
        this.status = status;
    }

    public Order() {}

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", orderDate=" + orderDate + ", durationDays=" + durationDays
                + ", user=" + user + ", car=" + car + ", status=" + status + "]";
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getDurationDays() {
        return durationDays;
    }

    public void setDurationDays(int durationDays) {
        this.durationDays = durationDays;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
