package com.luxuryautomotive.lab;

import com.luxuryautomotive.lab.controllers.CustomerController;
import com.luxuryautomotive.lab.controllers.NbaController;
import com.luxuryautomotive.lab.controllers.OptionalController;
import com.luxuryautomotive.lab.controllers.RuleEngineController;

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

	@Autowired 
	OptionalController optionalController;

	@Autowired
	RuleEngineController ruleEngineController;
	

	@Test
	void contextLoads() throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("model_id", "1");
		//jsonObject.put("customer_id", "94");
		//jsonObject.put("status","ACTIVE");
		//jsonObject.put("category","NEW CAR SALE");
		System.out.println(ruleEngineController.getOptionalByModelId(jsonObject.toString()));
	}


}
