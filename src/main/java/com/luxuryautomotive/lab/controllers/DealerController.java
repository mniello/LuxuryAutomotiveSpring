package com.luxuryautomotive.lab.controllers;

import java.util.List;
import java.util.Optional;
import org.json.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.luxuryautomotive.lab.domain.Dealer;
import com.luxuryautomotive.lab.repositories.DealerRepository;



@RestController
public class DealerController {
	
	@Autowired
	private DealerRepository dealerRepository;
	
	@GetMapping("/findDealerByEmail/{email}")
	public Boolean findByEmail(@PathVariable String email) {
		Optional<Dealer> dealer = dealerRepository.findById(email);
		return dealer.isPresent();
	}
	
	@PostMapping("/login")
	public Dealer findPassword(@RequestBody String body ) {
		JSONObject jsonObject = new JSONObject(body);
		String email = jsonObject.getString("email");
		String password = jsonObject.getString("password");
		Optional<Dealer> dealer = dealerRepository.findById(email);
		Dealer dealer2;
		if(dealer.isPresent()) {
			dealer2 = dealer.get();
			if(dealer2.getPassword().equals(password))
				return dealer2;
		}
		return null;	
	}

	@PostMapping("/findAllDealer")
	public List<Dealer> findAllDealer() {
		return dealerRepository.findAll();
	}

}
