package com.luxuryautomotive.lab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.luxuryautomotive.lab.domain.Order;
import com.luxuryautomotive.lab.repositories.OrderRepository;



@RestController
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;

	@PostMapping("/insertOrder")
	public Order insertOrder(@RequestBody Order order) {
		return orderRepository.save(order);	
	}

}
