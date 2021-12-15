package com.luxuryautomotive.lab.controllers;

import java.util.List;

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
	
	
	//DA CAMBIARE
	@GetMapping("/getNbaByDealer")
	public List<Nba> findByDealer(String dealer_email){
		return nbaRepository.findAll();
	}
	
}
