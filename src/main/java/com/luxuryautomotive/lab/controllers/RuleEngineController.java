package com.luxuryautomotive.lab.controllers;

import java.sql.Date;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.luxuryautomotive.lab.domain.Nba;
import com.luxuryautomotive.lab.domain.Optional;
import com.luxuryautomotive.lab.domain.Order;
import com.luxuryautomotive.lab.domain.Vehicle;
import com.luxuryautomotive.lab.domain.Warranty;

import org.json.JSONArray;
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

    @Autowired
    NbaController nbaController;

    @PostMapping("/getLastWarrantyByCustomer")
    public Integer getLastWarranty(@RequestBody String body) {
        JSONObject jsonObject = new JSONObject(body);
		String customer_id = jsonObject.getString("customer_id");
		Query query = entityManager.createNamedQuery("getLastWarrantyByCustomer");
		query.setParameter("id", customer_id);
        List order = query.getResultList();
        Warranty warranty = (Warranty) order.get(0);
        Integer month = (int) ChronoUnit.MONTHS.between(YearMonth.from(warranty.getStart_date().toLocalDate()), warranty.getEnd_date().toLocalDate());
        System.out.println("DURATA MESI"+month);
        return month;
		
    }

    @PostMapping("/getLastOptionalByCustomer")
    public Optional getLastOptionalByCustomer(@RequestBody String body) {
        JSONObject jsonObject = new JSONObject(body);
		String customer_id = jsonObject.getString("customer_id");
		Query query = entityManager.createNamedQuery("getLastOptionalByCustomer");
		query.setParameter("id", customer_id);
        query.setParameter("order_type", "CAR PURCHASE");
        List op = query.getResultList();
        Optional optional = (Optional) op.get(0);
        return optional;
    }

    @PostMapping("/getOptionalCategoryByRankCustomer")
    public List<String> getOptionalCategoryByRankCustomer(@RequestBody String body) {
        JSONObject jsonObject = new JSONObject(body);
        String rank = jsonObject.getString("customer_rank");
        Query query = entityManager.createNativeQuery("select nuova.category from(select top 3 category, count(category) as num from [dbo].[optional] where vin in(select [dbo].[vehicle].vin from [dbo].[order_] , [dbo].[vehicle] , [dbo].[customer] where [dbo].[order_].vin = [dbo].[vehicle].vin and [dbo].[order_].customer_id = [dbo].[customer].customer_id and [dbo].[customer].customer_rank =:rank and [dbo].[order_].order_type = 'CAR PURCHASE') group by category order by num DESC) as nuova");
        query.setParameter("rank", rank);
        List<String> category = query.getResultList();
        return category;
    }

    @PostMapping("/getWarrantyDurationByRankCustomer")
    public Integer getWarrantyDurationByRankCustomer(@RequestBody String body) {
        JSONObject jsonObject = new JSONObject(body);
        String rank = jsonObject.getString("customer_rank");
        Query query = entityManager.createNativeQuery("select tabella.durata from(select top 1 nuova.durata , count(nuova.durata) as num  from(SELECT DATEDIFF(month,start_date,end_date) as durata  from [dbo].[warranty] , [dbo].[order_] , [dbo].[customer] where start_date!='' and [dbo].[order_].order_id = [dbo].[warranty].order_id and [dbo].[order_].customer_id = [dbo].[customer].customer_id and [dbo].[customer].customer_rank=:rank) as nuova group by nuova.durata order by num desc) as tabella");
        query.setParameter("rank", rank);
        Integer duration = (Integer)query.getSingleResult();
        return duration;

    }

    @PostMapping("/getTop3WarrantyDurationByRankCustomer")
    public List<Integer> getTop3WarrantyDurationByRankCustomer(@RequestBody String body) {
        JSONObject jsonObject = new JSONObject(body);
        String rank = jsonObject.getString("customer_rank");
        Query query = entityManager.createNativeQuery("select tabella.durata from(select top 3 nuova.durata , count(nuova.durata) as num  from(SELECT DATEDIFF(month,start_date,end_date) as durata  from [dbo].[warranty] , [dbo].[order_] , [dbo].[customer] where start_date!='' and [dbo].[order_].order_id = [dbo].[warranty].order_id and [dbo].[order_].customer_id = [dbo].[customer].customer_id and [dbo].[customer].customer_rank=:rank) as nuova group by nuova.durata order by num desc) as tabella");
        query.setParameter("rank", rank);
        return query.getResultList();
    }


    @PostMapping("/getTopOptionalByModelId")
    public List<String> getTopOptionalByModelId(@RequestBody String body) {
        JSONObject jsonObject = new JSONObject(body);
        String model_id = jsonObject.getString("model_id");
        Query query = entityManager.createNativeQuery("select nuova.category from (select top 3 category ,count(category) as num from [dbo].[optional] where vin in (select vin from [dbo].[vehicle_model], [dbo].[vehicle] where [dbo].[vehicle].model_id = [dbo].[vehicle_model].model_id and [dbo].[vehicle_model].model_id=:model_id) group by category order by num DESC) as nuova ");
        query.setParameter("model_id", model_id);
        return query.getResultList();
    }

    @PostMapping("/getOptionalByModelId") //DA PROVARE
    public List<String> getOptionalByModelId(@RequestBody String body) {
        JSONObject jsonObject = new JSONObject(body);
        String model_id = jsonObject.getString("model_id");
        Query query = entityManager.createNativeQuery("select nuova.category from (select category , count(category) as num from [dbo].[optional] where vin in (select vin from [dbo].[vehicle_model], [dbo].[vehicle] where [dbo].[vehicle].model_id = [dbo].[vehicle_model].model_id and [dbo].[vehicle_model].model_id=:model_id) group by category) as nuova ");
        query.setParameter("model_id", model_id);
        return query.getResultList();
    }


    
    
}
