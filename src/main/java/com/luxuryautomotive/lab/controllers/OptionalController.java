package com.luxuryautomotive.lab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.luxuryautomotive.lab.domain.Optional;
import com.luxuryautomotive.lab.repositories.OptionalRepository;

@RestController
public class OptionalController {

	@Autowired
	private OptionalRepository optionalRepository;

	@PostMapping("/findAllOptional")
	public List<Optional> findAllOptional() {
		return optionalRepository.findAll();
	}
}
