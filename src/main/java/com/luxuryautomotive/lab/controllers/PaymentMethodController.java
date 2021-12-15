package com.luxuryautomotive.lab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.luxuryautomotive.lab.repositories.PaymentMethodRepository;

@RestController
public class PaymentMethodController {

	@Autowired
	private PaymentMethodRepository methodRepository;
}
