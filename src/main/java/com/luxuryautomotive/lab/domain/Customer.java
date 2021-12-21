package com.luxuryautomotive.lab.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import lombok.Data;

@Entity
@Table
@Data
@NamedNativeQueries(
	@NamedNativeQuery(name ="getCustomerByDealer", query = "select customer.* from customer,[order] where customer.customer_id = [order].customer_id and [order].dealer_email\\:=email", resultClass = Customer.class)
)
public class Customer {
	
	
	@Id
	private String customer_id;
	private String customer_email;
	private String first_name;
	private String last_name;
	private String city;
	private String region;
	private String country;
	private Date date_of_birth;
	private String telephone_number;
	private String customer_rank;
	
	
	public Customer(String customer_id, String customer_email, String first_name, String last_name, String city,
			String region, String country, Date date_of_birth, String telephone_number, String customer_rank) {
		super();
		this.customer_id = customer_id;
		this.customer_email = customer_email;
		this.first_name = first_name;
		this.last_name = last_name;
		this.city = city;
		this.region = region;
		this.country = country;
		this.date_of_birth = date_of_birth;
		this.telephone_number = telephone_number;
		this.customer_rank = customer_rank;
	}


	public Customer() {
		super();
	}


	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customer_email=" + customer_email + ", first_name="
				+ first_name + ", last_name=" + last_name + ", city=" + city + ", region=" + region + ", country="
				+ country + ", date_of_birth=" + date_of_birth + ", telephone_number=" + telephone_number
				+ ", customer_rank=" + customer_rank + "]";
	}


	public String getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}


	public String getCustomer_email() {
		return customer_email;
	}


	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public Date getDate_of_birth() {
		return date_of_birth;
	}


	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}


	public String getTelephone_number() {
		return telephone_number;
	}


	public void setTelephone_number(String telephone_number) {
		this.telephone_number = telephone_number;
	}


	public String getCustomer_rank() {
		return customer_rank;
	}


	public void setCustomer_rank(String customer_rank) {
		this.customer_rank = customer_rank;
	}
	
	
	
	
	
	

}
