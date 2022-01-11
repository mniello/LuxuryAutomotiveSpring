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

	@PostMapping("/getOptionalByModelId")
	public List<Optional> getOptionalByModelId(@RequestBody String body) {
		JSONObject jsonObject = new JSONObject(body);
		String model_id = jsonObject.getString("model_id");
		Query query = entityManager.createNamedQuery("getOptionalByModelId");
		query.setParameter("model", model_id);
		return query.getResultList();
	}
}
