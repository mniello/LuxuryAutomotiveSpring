package com.luxuryautomotive.lab.controllers;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import com.luxuryautomotive.lab.domain.Vehicle;
import com.luxuryautomotive.lab.repositories.VehicleRepository;

@RestController
public class VehicleController {
	
	@Autowired
	private VehicleRepository vehicleRepository;

	@PostMapping("/getVehicleById")
	public Vehicle getVehicleById(@RequestBody String body) {
		JSONObject jsonObject = new JSONObject(body);
		String id = jsonObject.getString("vehicle_id");
		Optional<Vehicle> vehicle = vehicleRepository.findById(id);
		if(vehicle.isPresent())
			return vehicle.get();
		return null;
	}

}
