package com.luxuryautomotive.lab.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.luxuryautomotive.lab.domain.Nba;
import com.luxuryautomotive.lab.repositories.NbaRepository;

@RestController
public class NbaController {

	@Autowired
	private NbaRepository nbaRepository;

	@Autowired
	EntityManager entityManager;
	
	
	//DA CAMBIARE
	@GetMapping("/getAllNbaByDealer")
	public List<Nba> findByDealer(String dealer_email){
		return nbaRepository.findAll();
	}

	@PostMapping("/getNbaByDealerCustomer")
	public List<Nba> getNbaByDealerCustomer(@RequestBody String body) {
		JSONObject jsonObject = new JSONObject(body);
		String email = jsonObject.getString("email");
		String customer_id = jsonObject.getString("customer_id");
		Query query = entityManager.createNamedQuery("getNbaByDealerCustomer");
		query.setParameter("email", email);
		query.setParameter("customer_id", customer_id);
		return query.getResultList();
	}

	@PostMapping("/getNbaByDealerCustomerStatus")
	public List<Nba> getNbaByDealerCustomerStatus(@RequestBody String body) {
		JSONObject jsonObject = new JSONObject(body);
		String email = jsonObject.getString("email");
		String customer_id = jsonObject.getString("customer_id");
		String status = jsonObject.getString("status");
		Query query = entityManager.createNamedQuery("getNbaByDealerCustomerStatus");
		query.setParameter("email", email);
		query.setParameter("customer_id", customer_id);
		query.setParameter("status", status);
		return query.getResultList();
	}
	
}
