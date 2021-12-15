package com.luxuryautomotive.lab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.luxuryautomotive.lab.repositories.OptionalRepository;

@RestController
public class OptionalController {

	@Autowired
	private OptionalRepository optionalRepository;
}
