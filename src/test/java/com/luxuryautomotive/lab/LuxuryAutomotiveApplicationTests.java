package com.luxuryautomotive.lab;

import com.luxuryautomotive.lab.controllers.CustomerController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LuxuryAutomotiveApplicationTests {

	@Autowired
	CustomerController controller;

	@Test
	void contextLoads() {
		controller.getCustomerByDealer("prova@email.com");
	}

}
