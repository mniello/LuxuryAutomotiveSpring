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

import com.luxuryautomotive.lab.domain.Vehicle;
import com.luxuryautomotive.lab.repositories.VehicleRepository;

@RestController
public class VehicleController {
	
	@Autowired
	private VehicleRepository vehicleRepository;

	@Autowired
	private EntityManager entityManager;

	@PostMapping("/getVehicleByVin")
	public Vehicle getVehicleById(@RequestBody String body) {
		JSONObject jsonObject = new JSONObject(body);
		String id = jsonObject.getString("vin");
		Optional<Vehicle> vehicle = vehicleRepository.findById(id);
		if(vehicle.isPresent())
			return vehicle.get();
		return null;
	}

	@PostMapping("/findAllVehicle")
	public List<Vehicle> findAllVehicle() {
		return vehicleRepository.findAll();
	}

	@PostMapping("/getVehicleByModelId")
	public List<Vehicle> getVehicleByModelId(@RequestBody String body) {
		JSONObject jsonObject = new JSONObject(body);
		String model_id = jsonObject.getString("model_id");
		Query query = entityManager.createNamedQuery("getVehicleByModelId");
		query.setParameter("model", model_id);
		return query.getResultList();
	}

}
