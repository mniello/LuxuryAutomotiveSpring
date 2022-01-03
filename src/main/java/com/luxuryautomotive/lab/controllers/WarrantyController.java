package com.luxuryautomotive.lab.controllers;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import com.luxuryautomotive.lab.domain.Warranty;
import com.luxuryautomotive.lab.repositories.WarrantyRepository;

@RestController
public class WarrantyController {
	
	@Autowired
	private WarrantyRepository warrantyRepository;

	@PostMapping("/getWarrantyById")
	public Warranty getVehicleById(@RequestBody String body) {
		JSONObject jsonObject = new JSONObject(body);
		String id = jsonObject.getString("warranty_id");
		Optional<Warranty> warranty = warrantyRepository.findById(id);
		if(warranty.isPresent())
			return warranty.get();
		return null;
	}
	

}
