package com.luxuryautomotive.lab.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.query.criteria.internal.CriteriaSubqueryImpl.SubquerySelection;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.luxuryautomotive.lab.domain.Nba;
import com.luxuryautomotive.lab.domain.Optional;
import com.luxuryautomotive.lab.domain.Order;
import com.luxuryautomotive.lab.domain.Vehicle;
import com.luxuryautomotive.lab.domain.Warranty;
import com.luxuryautomotive.lab.repositories.NbaRepository;

@RestController
public class NbaController {

	@Autowired
	private NbaRepository nbaRepository;

	@Autowired
	EntityManager entityManager;

	@Autowired
    OrderController orderController;

    @Autowired 
    VehicleController vehicleController;

	@Autowired
    OptionalController optionalController;

	@Autowired
	WarrantyController warrantyController;
	
	
	@PostMapping("/getNbaByDealer")
	public List<Nba> getNbaByDealer(@RequestBody String body){
		JSONObject jsonObject = new JSONObject(body);
		String email = jsonObject.getString("dealer_email");
		Query query = entityManager.createNamedQuery("getNbaByDealer");
		query.setParameter("email", email);
		return query.getResultList();
	}

	@PostMapping("/getNbaByDealerStatus")
	public List<Nba> getNbaByDealerStatus(@RequestBody String body){
		JSONObject jsonObject = new JSONObject(body);
		String email = jsonObject.getString("dealer_email");
		String status = jsonObject.getString("status");
		Query query = entityManager.createNamedQuery("getNbaByDealerStatus");
		query.setParameter("status", status);
		query.setParameter("email", email);
		return query.getResultList();
	}

	@PostMapping("/getNbaByDealerCustomer")
	public List<Nba> getNbaByDealerCustomer(@RequestBody String body) {
		JSONObject jsonObject = new JSONObject(body);
		String email = jsonObject.getString("dealer_email");
		String customer_id = jsonObject.getString("customer_id");
		Query query = entityManager.createNamedQuery("getNbaByDealerCustomer");
		query.setParameter("email", email);
		query.setParameter("customer_id", customer_id);
		return query.getResultList();
	}

	@PostMapping("/getNbaByDealerCustomerStatus")
	public List<Nba> getNbaByDealerCustomerStatus(@RequestBody String body) {
		JSONObject jsonObject = new JSONObject(body);
		String email = jsonObject.getString("dealer_email");
		String customer_id = jsonObject.getString("customer_id");
		String status = jsonObject.getString("status");
		Query query = entityManager.createNamedQuery("getNbaByDealerCustomerStatus");
		query.setParameter("email", email);
		query.setParameter("customer_id", customer_id);
		query.setParameter("status", status);
		return query.getResultList();
	}

	@PostMapping("/getNbaByDealerCustomerCategory")
	public List<Nba> getNbaByDealerCustomerCategory(@RequestBody String body) {
		JSONObject jsonObject = new JSONObject(body);
		String email = jsonObject.getString("dealer_email");
		String customer_id = jsonObject.getString("customer_id");
		String category = jsonObject.getString("category");
		Query query = entityManager.createNamedQuery("getNbaByDealerCustomerCategory");
		query.setParameter("email", email);
		query.setParameter("customer_id", customer_id);
		query.setParameter("category", category);
		return query.getResultList();
	}

	@PostMapping("/getNbaByDealerCustomerCategoryStatus")
	public List<Nba> getNbaByDealerCustomerCategoryStatus(@RequestBody String body) {
		JSONObject jsonObject = new JSONObject(body);
		String email = jsonObject.getString("dealer_email");
		String customer_id = jsonObject.getString("customer_id");
		String category = jsonObject.getString("category");
		String status = jsonObject.getString("status");
		Query query = entityManager.createNamedQuery("getNbaByDealerCustomerCategoryStatus");
		query.setParameter("email", email);
		query.setParameter("customer_id", customer_id);
		query.setParameter("category", category);
		query.setParameter("status", status);
		return query.getResultList();
	}

	@PostMapping("/findAllNba")
	public List<Nba> findAllNba() {
		return nbaRepository.findAll();
	}

	@PostMapping("/getNbaById")
	public Nba getNbaById(@RequestBody String body) {
		JSONObject jsonObject = new JSONObject(body);
		String id = jsonObject.getString("nba_id");
		if(nbaRepository.findById(id).isPresent()) {
			return nbaRepository.findById(id).get();
		} else {
			return null;
		}
	}

	@Transactional
	@PostMapping("/finalizeNbaWithOptional")
    public boolean finalizeNbaWithOptional(@RequestBody String body) {
        JSONObject jsonObject = new JSONObject(body);
        String nba_id = jsonObject.getString("nba_id");
		System.out.println(nba_id);
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("nba_id", nba_id);
        Nba nba = getNbaById(jsonObject2.toString());
		if(nba==null|| nba.getStatus().equals("FINALIZED")) {
			return false;
		}
        nba.setStatus("FINALIZED");
        nba.setClosure_date(new Date(System.currentTimeMillis()));
        jsonObject2 = new JSONObject();
        jsonObject2.put("order_id",nba.getOrder_id());
        Order order = orderController.getOrderById(jsonObject2.toString());
        String paymentType = jsonObject.getString("payment_type");
        order.setPayment_type(paymentType);
		if(order.getDate()==null) {
			order.setDate(new Date(System.currentTimeMillis()));
		}
        String vin = jsonObject.getString("vin");
        if(nba.getCategory().equals("NEW CAR SALE")) {
            jsonObject2 = new JSONObject();
            jsonObject2.put("vin",vin);
            Vehicle vehicle = vehicleController.getVehicleById(jsonObject2.toString());
			if(vehicle == null||vehicle.getStart_ownership_date()!=null) {
				return false;
			}
            vehicle.setStart_ownership_date(new Date(System.currentTimeMillis()));
			vehicle.setOwnership(Boolean.TRUE);
        }

        List<Optional> list = optionalController.findAllOptional();
        int max = 0;
        for(int i =0;i<list.size();i++) {
            if(Integer.parseInt(list.get(i).getOptional_id())>max) {
                max = Integer.parseInt(list.get(i).getOptional_id());
            }
        }
        max++;
		System.out.println("MAX "+ max);

        JSONArray array = jsonObject.getJSONArray("optionals");
        for(int i=0;i<array.length();i++) {
            String category = array.getString(i);
			System.out.print(array.getString(i));

			Query query = entityManager.createNativeQuery("INSERT INTO [dbo].[optional] (optional_id, vin,category,purchase_date) VALUES (:optional_id, :vin, :category, :data)");
            query.setParameter("optional_id", max);
            query.setParameter("vin", vin);
            query.setParameter("category", category);
            Date date = new Date(System.currentTimeMillis());
            query.setParameter("data", date);
            query.executeUpdate();
            max++;
        }
        return true;
    }

	@Transactional
	@PostMapping("/rejectedNba")
	public boolean rejectedNba(@RequestBody String body) {
		JSONObject jsonObject = new JSONObject(body);
        String nba_id = jsonObject.getString("nba_id");
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("nba_id", nba_id);
        Nba nba = getNbaById(jsonObject2.toString());
		if(nba==null|| nba.getStatus().equals("FINALIZED")) {
			return false;
		}
		nba.setStatus("REJECTED");
		nba.setClosure_date(new Date(System.currentTimeMillis()));
		jsonObject2 = new JSONObject();
        jsonObject2.put("order_id",nba.getOrder_id());
        Order order = orderController.getOrderById(jsonObject2.toString());
		if(order.getDate()==null) {
			order.setDate(new Date(System.currentTimeMillis()));
		}

		return true;
	}

	@Transactional
	@PostMapping("/finalizeNbaWarranty")
	public boolean finalizeNbaWarranty(@RequestBody String body) {
		JSONObject jsonObject = new JSONObject(body);
        String nba_id = jsonObject.getString("nba_id");
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("nba_id", nba_id);
        Nba nba = getNbaById(jsonObject2.toString());
		if(nba==null|| nba.getStatus().equals("FINALIZED")) {
			return false;
		}
		nba.setStatus("FINALIZED");
		nba.setClosure_date(new Date(System.currentTimeMillis()));
		jsonObject2 = new JSONObject();
        jsonObject2.put("order_id",nba.getOrder_id());
        Order order = orderController.getOrderById(jsonObject2.toString());
        String paymentType = jsonObject.getString("payment_type");
		order.setPayment_type(paymentType);
		if(order.getDate()==null) {
			order.setDate(new Date(System.currentTimeMillis()));
		}
		
		Warranty warranty = warrantyController.getWarrantyByOrder(jsonObject2.toString()).get(0);
		warranty.setStart_date(new Date(System.currentTimeMillis()));
		Date end_date = new Date(System.currentTimeMillis());
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(end_date);
		int month = jsonObject.getInt("month");
		calendar.add(Calendar.MONTH,month);
		end_date = new Date(calendar.getTimeInMillis());
		warranty.setEnd_date(end_date);
		return true;
	}
	
}
