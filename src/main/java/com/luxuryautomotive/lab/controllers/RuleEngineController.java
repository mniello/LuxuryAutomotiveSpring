package com.luxuryautomotive.lab.controllers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.luxuryautomotive.lab.domain.Warranty;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RuleEngineController {

    @Autowired
    WarrantyController warrantyController;

    @Autowired
    OptionalController optionalController;

    @Autowired
    EntityManager entityManager;

    @PostMapping("/getLastWarrantyByCustomer")
    public List<Warranty> getLastWarranty(@RequestBody String body) {
        JSONObject jsonObject = new JSONObject(body);
		String customer_id = jsonObject.getString("customer_id");
        String order_type = "WARRANTY";
		Query query = entityManager.createNamedQuery("getOrderByCustomerForLastWarranty");
		query.setParameter("id", customer_id);
        query.setParameter("order_type", order_type);
        List order = query.getResultList();
        
        jsonObject = new JSONObject();
        jsonObject.put("order_id", order.get(0));

        return warrantyController.getWarrantyByOrder(jsonObject.toString());
		
    }
    
}
