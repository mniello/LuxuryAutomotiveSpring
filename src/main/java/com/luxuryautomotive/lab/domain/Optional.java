package com.luxuryautomotive.lab.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class Optional {

	@Id
	private String optional_id;
	private String model_id;
	private String description;
	private String category;
	private Float price;
	private Date purchase_date;
	public Optional(String optional_id, String model_id, String description, String category, Float price,
			Date purchase_date) {
		super();
		this.optional_id = optional_id;
		this.model_id = model_id;
		this.description = description;
		this.category = category;
		this.price = price;
		this.purchase_date = purchase_date;
	}
	public Optional() {
		super();
	}
	@Override
	public String toString() {
		return "Optional [optional_id=" + optional_id + ", model_id=" + model_id + ", description=" + description
				+ ", caregory=" + category + ", price=" + price + ", purchase_date=" + purchase_date + "]";
	}
	public String getOptional_id() {
		return optional_id;
	}
	public void setOptional_id(String optional_id) {
		this.optional_id = optional_id;
	}
	public String getModel_id() {
		return model_id;
	}
	public void setModel_id(String model_id) {
		this.model_id = model_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String caregory) {
		this.category = caregory;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Date getPurchase_date() {
		return purchase_date;
	}
	public void setPurchase_date(Date purchase_date) {
		this.purchase_date = purchase_date;
	}
	
	
}
