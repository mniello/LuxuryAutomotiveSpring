package com.luxuryautomotive.lab.controllers;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

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

	@PostMapping("/getOrderById")
	public Order getOrderById(@RequestBody String body) {
		JSONObject jsonObject = new JSONObject(body);
		String id = jsonObject.getString("id");
		Optional<Order> order = orderRepository.findById(id);
		if(order.isPresent())
			return order.get();
		return null;
	}

}
