package com.carApi.Car_Management.entity;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="UserDetails")
@CrossOrigin(origins = "http://localhost:3000") // Adjust as necessary
public class User {

    @Id
    @Column(name="UserId")
    private int UserId;

    @Column(name="UserName")
    private String UserName;

    @Column(name="UserAge")
    private int UserAge;

    @Column(name="Email")
    private String email;

    @Column(name="Password")
    private String password;

    @Column(name="Status")
    private String status;  //Blocked, Active, Inactive

    @Column(name="City")
    private String city;

    @Column(name="Role")
    private String role;  //Customer, Admin

    // Constructors, Getters, Setters, and toString() method
    public User(int id, String UserName, int age, String email, String password, String status, String city, String role) {
        this.UserId = id;
        this.UserName = UserName;
        this.UserAge = age;
        this.email = email;
        this.password = password;
        this.status = status;
        this.city = city;
        this.role = role;
    }

    public User() {}

    public int getId() {
        return UserId;
    }

    public void setId(int id) {
        this.UserId = id;
    }

    public String getUsername() {
        return UserName;
    }

    public void setUsername(String username) {
        this.UserName = username;
    }

    public int getAge() {
        return UserAge;
    }

    public void setAge(int age) {
        this.UserAge = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User [id=" + UserId + ", username=" + UserName + ", age=" + UserAge + ", email=" + email + ", password="
                + password + ", status=" + status + ", city=" + city + ", role=" + role + "]";
    }
}
