package com.luxuryautomotive.lab.controllers;

import java.util.List;
import java.util.Optional;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		Query query = session.getNamedQuery("getCustomerByDealer");
		query.setParameter("email", email);
		return query.getResultList();
	}

	@GetMapping("/findCustomerById/{id}")
	public Boolean findByEmail(@PathVariable String id) {
		Optional<Customer> customer = customerRepository.findById(id);
		return customer.isPresent();
	}
}
