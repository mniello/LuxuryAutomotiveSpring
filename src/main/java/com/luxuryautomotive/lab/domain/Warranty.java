package com.luxuryautomotive.lab.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
@NamedQueries({
	@NamedQuery(name ="getWarrantyByOrder", query = "select w from Warranty w where w.order_id=:id"),
	@NamedQuery(name ="getLastWarrantyByCustomer", query = "select w from Warranty w , Order o  where w.order_id = o.order_id and o.customer_id=:id and w.start_date is not null ORDER BY w.start_date DESC")
})
public class Warranty {
	
	@Id
	private String warranty_id;
	private String order_id;
	private String description;
	private Date start_date;
	private Date end_date;
	
	public Warranty(String warranty_id, String order_id, String description, Date start_date, Date end_date) {
		super();
		this.warranty_id = warranty_id;
		this.order_id = order_id;
		this.description = description;
		this.start_date = start_date;
		this.end_date = end_date;
	}

	public Warranty() {
		super();
	}

	@Override
	public String toString() {
		return "Warranty [warranty_id=" + warranty_id + ", order_id=" + order_id + ", description=" + description
				+ ", start_date=" + start_date + ", end_date=" + end_date + "]";
	}

	public String getWarranty_id() {
		return warranty_id;
	}

	public void setWarranty_id(String warranty_id) {
		this.warranty_id = warranty_id;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	} 
	
	
	

}
