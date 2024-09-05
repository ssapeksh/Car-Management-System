package com.carApi.Car_Management.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carApi.Car_Management.entity.Order;

import com.carApi.Car_Management.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderreporef;
	
	public Collection<Order> GetAllOrder()
	{
		Collection<Order> getallorder = orderreporef.findAll();
		return getallorder;
	}
	
	
	public Order GetOneOrder(Integer id)
	{
		Optional<Order> optionalorder=orderreporef.findById(id);
		return optionalorder.orElse(null);
	}
	
	
}
