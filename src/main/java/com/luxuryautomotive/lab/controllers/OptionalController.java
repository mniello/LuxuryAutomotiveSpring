package com.luxuryautomotive.lab.controllers;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.luxuryautomotive.lab.domain.Optional;
import com.luxuryautomotive.lab.repositories.OptionalRepository;

@RestController
public class OptionalController {

	@Autowired
	private OptionalRepository optionalRepository;

	@Autowired
	private EntityManager entityManager;

	@PostMapping("/findAllOptional")
	public List<Optional> findAllOptional() {
		return optionalRepository.findAll();
	}

	@PostMapping("/getOptionalByVin")
	public List<Optional> getOptionalByVin(@RequestBody String body) {
		JSONObject jsonObject = new JSONObject(body);
		String vin = jsonObject.getString("vin");
		Query query = entityManager.createNamedQuery("getOptionalByVin");
		query.setParameter("vin", vin);
		return query.getResultList();
	}
}
