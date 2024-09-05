package com.carApi.Car_Management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carApi.Car_Management.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
