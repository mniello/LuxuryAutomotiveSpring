package com.luxuryautomotive.lab.controllers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
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

	@Autowired
	Session session;
	
	@GetMapping("/getCustomerByDealer/{email}")
	public List<Customer> getCustomerByDealer(@PathVariable String email) {
		NativeQuery query = session.getNamedNativeQuery("getCustomerByDealer");
		query.setParameter("email", email);
		return query.getResultList();
	}
	

}
