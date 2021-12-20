package com.luxuryautomotive.lab.controllers;

import java.util.List;
import java.util.Optional;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.luxuryautomotive.lab.domain.Customer;
import com.luxuryautomotive.lab.repositories.CustomerRepository;



@RestController
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;

	@PersistenceContext
	Session session;
	
	@GetMapping("/getCustomerByDealer/{email}")
	public List<Customer> getCustomerByDealer(@PathVariable String email) {
		NativeQuery query = session.getNamedNativeQuery("getCustomerByDealer");
		query.setParameter("email", email);
		return query.getResultList();
	}

	@PostMapping("/findCustomerById")
	public Customer findById(@RequestBody String body) {
		JSONObject jsonObject = new JSONObject(body);
		String id = jsonObject.getString("id");
		Customer customer = null;
		customer = customerRepository.findById(id).get();
		return customer;
	}

	@GetMapping("/getCustomerById/{id}")
	public Boolean getById(@PathVariable String id) {
		Optional<Customer> customer = customerRepository.findById(id);
		return customer.isPresent();
	}
}
