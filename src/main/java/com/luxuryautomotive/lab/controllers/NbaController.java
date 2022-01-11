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
	
	
	@PostMapping("/getNbaByDealer")
	public List<Nba> getNbaByDealer(@RequestBody String body){
		JSONObject jsonObject = new JSONObject(body);
		String email = jsonObject.getString("email");
		Query query = entityManager.createNamedQuery("getNbaByDealer");
		query.setParameter("email", email);
		return query.getResultList();
	}

	@PostMapping("/getNbaByDealerStatus")
	public List<Nba> getNbaByDealerStatus(@RequestBody String body){
		JSONObject jsonObject = new JSONObject(body);
		String email = jsonObject.getString("email");
		String status = jsonObject.getString("status");
		Query query = entityManager.createNamedQuery("getNbaByDealerStatus");
		query.setParameter("status", status);
		query.setParameter("email", email);
		return query.getResultList();
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

	@PostMapping("/getNbaByDealerCustomerCategory")
	public List<Nba> getNbaByDealerCustomerCategory(@RequestBody String body) {
		JSONObject jsonObject = new JSONObject(body);
		String email = jsonObject.getString("email");
		String customer_id = jsonObject.getString("customer_id");
		String category = jsonObject.getString("category");
		Query query = entityManager.createNamedQuery("getNbaByDealerCustomerCategory");
		query.setParameter("email", email);
		query.setParameter("customer_id", customer_id);
		query.setParameter("category", category);
		return query.getResultList();
	}

	@PostMapping("/getNbaByDealerCustomerCategoryStatus")
	public List<Nba> getNbaByDealerCustomerCategoryStatus(@RequestBody String body) {
		JSONObject jsonObject = new JSONObject(body);
		String email = jsonObject.getString("email");
		String customer_id = jsonObject.getString("customer_id");
		String category = jsonObject.getString("category");
		String status = jsonObject.getString("status");
		Query query = entityManager.createNamedQuery("getNbaByDealerCustomerCategoryStatus");
		query.setParameter("email", email);
		query.setParameter("customer_id", customer_id);
		query.setParameter("category", category);
		query.setParameter("status", status);
		return query.getResultList();
	}

	@PostMapping("/findAllNba")
	public List<Nba> findAllNba() {
		return nbaRepository.findAll();
	}
	
}
