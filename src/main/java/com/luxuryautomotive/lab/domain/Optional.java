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
	@NamedQuery(name ="getOptionalByVin", query = "select o from Optional o where o.vin=:vin"),
})
public class Optional {

	@Id
	private String optional_id;
	private String vin;
	private String description;
	private String category;
	private Float price;
	private Date purchase_date;
	public Optional(String optional_id, String vin, String description, String category, Float price,
			Date purchase_date) {
		super();
		this.optional_id = optional_id;
		this.vin = vin;
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
		return "Optional [optional_id=" + optional_id + ", vin=" + vin + ", description=" + description
				+ ", caregory=" + category + ", price=" + price + ", purchase_date=" + purchase_date + "]";
	}
	public String getOptional_id() {
		return optional_id;
	}
	public void setOptional_id(String optional_id) {
		this.optional_id = optional_id;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
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
