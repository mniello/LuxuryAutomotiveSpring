package com.luxuryautomotive.lab;

import java.util.ArrayList;

import com.luxuryautomotive.lab.controllers.CustomerController;
import com.luxuryautomotive.lab.controllers.NbaController;
import com.luxuryautomotive.lab.controllers.OptionalController;
import com.luxuryautomotive.lab.controllers.RuleEngineController;

import org.json.JSONArray;
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
		jsonObject.put("customer_rank", "VIP");
		jsonObject.put("nba_id", "101");
		jsonObject.put("payment_type","CREDIT CARD");
		jsonObject.put("month", "18");
		ArrayList<String> arrayList = new ArrayList<>(){};
		arrayList.add("KEYLESS SYSTEM");
		arrayList.add("PUTTANA EVA");
		JSONArray array = new JSONArray(arrayList);
		jsonObject.put("optionals", array);
		jsonObject.put("customer_id", "1");
		//jsonObject.put("status","ACTIVE");
		//jsonObject.put("category","NEW CAR SALE");
		//System.out.println(ruleEngineController.getTop3WarrantyDurationByRankCustomer(jsonObject.toString()));
	}


}
