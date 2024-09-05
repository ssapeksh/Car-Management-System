package com.carApi.Car_Management.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.carApi.Car_Management.entity.Order;
import com.carApi.Car_Management.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderservref;
	
	@GetMapping("/api/orders")
	public Collection<Order> GetAllOrder()
	{
		return orderservref.GetAllOrder();
	}
	
	@GetMapping("/api/order/{id}")
	public Order GetOneOrder(@PathVariable Integer id)
	{
		return orderservref.GetOneOrder(id);
	}
	

}
