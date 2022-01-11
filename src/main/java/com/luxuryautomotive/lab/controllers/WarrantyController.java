package com.luxuryautomotive.lab.controllers;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.luxuryautomotive.lab.domain.Warranty;
import com.luxuryautomotive.lab.repositories.WarrantyRepository;

@RestController
public class WarrantyController {
	
	@Autowired
	private WarrantyRepository warrantyRepository;

	@Autowired EntityManager entityManager;

	@PostMapping("/getWarrantyById")
	public Warranty getVehicleById(@RequestBody String body) {
		JSONObject jsonObject = new JSONObject(body);
		String id = jsonObject.getString("warranty_id");
		Optional<Warranty> warranty = warrantyRepository.findById(id);
		if(warranty.isPresent())
			return warranty.get();
		return null;
	}
	
	@PostMapping("/findAllWarranty")
	public List<Warranty> findAllWarranty() {
		return warrantyRepository.findAll();
	}

	@PostMapping("/getWarrantyByOrder")
	public List<Warranty> getWarrantyByOrder(@RequestBody String body) {
		JSONObject jsonObject = new JSONObject(body);
		String order_id = jsonObject.getString("order_id");
		Query query = entityManager.createNamedQuery("getWarrantyByOrder");
		query.setParameter("id", order_id);
		return query.getResultList();
	}

}
