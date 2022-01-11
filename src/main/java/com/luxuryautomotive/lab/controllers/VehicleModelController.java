package com.luxuryautomotive.lab.controllers;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import com.luxuryautomotive.lab.domain.VehicleModel;
import com.luxuryautomotive.lab.repositories.VehicleModelRepository;
import com.luxuryautomotive.lab.repositories.VehicleRepository;

@RestController
public class VehicleModelController {

	@Autowired
	private VehicleModelRepository vehicleModelRepository;

	@PostMapping("/getVehicleModelById")
	public VehicleModel getVehicleModelById(@RequestBody String body) {
		JSONObject jsonObject = new JSONObject(body);
		String id = jsonObject.getString("model_id");
		Optional<VehicleModel> vehicleModel = vehicleModelRepository.findById(id);
		if(vehicleModel.isPresent())
			return vehicleModel.get();
		return null;
	}

	@PostMapping("/findAllVehicleModel")
	public List<VehicleModel> findAllVehicleModel() {
		return vehicleModelRepository.findAll();
	}
}
