package com.luxuryautomotive.lab.controllers;

import java.util.List;

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
	
	/*@GetMapping("/findCustomerByDealer/{dealer}")
	public List<Customer> findCustomerByDealer(@PathVariable String dealer) {
		
	}*/
	

}
