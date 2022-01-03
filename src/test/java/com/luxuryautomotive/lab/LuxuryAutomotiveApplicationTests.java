package com.luxuryautomotive.lab;

import com.luxuryautomotive.lab.controllers.CustomerController;
import com.luxuryautomotive.lab.controllers.NbaController;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LuxuryAutomotiveApplicationTests {

	@Autowired
	CustomerController customerController;

	@Autowired
	NbaController nbaController;

	@Test
	void contextLoads() throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("email", "aanderssone0@purevolume.com");
		jsonObject.put("customer_id", "4");
		jsonObject.put("status","FINALIZED");
		jsonObject.put("category","NEW CAR SALE");
		System.out.println(nbaController.getNbaByDealerCustomerCategory(jsonObject.toString()));
	}

}
