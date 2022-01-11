package com.luxuryautomotive.lab.controllers;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
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

	@Autowired
	EntityManager entityManager;
	
	@PostMapping("/getCustomerByDealer")
	public List<Customer> getCustomerByDealer(@RequestBody String body) {
		JSONObject jsonObject = new JSONObject(body);
		String email = jsonObject.getString("dealer_email");
		Query query = entityManager.createNamedQuery("getCustomerByDealer");
		query.setParameter("email", email);
		return query.getResultList();
	}

	@PostMapping("/getCustomerById")
	public Customer getCustomerById(@RequestBody String body) {
		JSONObject jsonObject = new JSONObject(body);
		String id = jsonObject.getString("customer_id");
		Optional<Customer> customer = customerRepository.findById(id);
		if(customer.isPresent())
			return customer.get();
		return null;
	}

	@PostMapping("/findAllCustomer")
	public List<Customer> findAllCustomer() {
		return customerRepository.findAll();
	}
}
