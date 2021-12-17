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
	@NamedNativeQuery(name ="getCustomerByDealer", query = "select customer.* from customer,[order] where customer.customer_id = [order].customer_id and [order].dealer_email:=email", resultClass = Customer.class)
)
public class Customer {
	
	public enum Rank{
		TOP,
		VIP,
		CUSTOMER
		}
	
	@Id
	private String customer_id;
	private String customerEmail;
	private String first_name;
	private String last_name;
	private String city;
	private String region;
	private String country;
	private Date dateOfBirth;
	private String telephone_number;
	private Rank customer_rank;
	
	
	public Customer(String customer_id, String customerEmail, String first_name, String last_name, String city,
			String region, String country, Date dateOfBirth, String telephone_number, Rank customer_rank) {
		super();
		this.customer_id = customer_id;
		this.customerEmail = customerEmail;
		this.first_name = first_name;
		this.last_name = last_name;
		this.city = city;
		this.region = region;
		this.country = country;
		this.dateOfBirth = dateOfBirth;
		this.telephone_number = telephone_number;
		this.customer_rank = customer_rank;
	}


	public Customer() {
		super();
	}


	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customerEmail=" + customerEmail + ", first_name="
				+ first_name + ", last_name=" + last_name + ", city=" + city + ", region=" + region + ", country="
				+ country + ", dateOfBirth=" + dateOfBirth + ", telephone_number=" + telephone_number
				+ ", customer_rank=" + customer_rank + "]";
	}


	public String getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}


	public String getCustomerEmail() {
		return customerEmail;
	}


	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
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


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getTelephone_number() {
		return telephone_number;
	}


	public void setTelephone_number(String telephone_number) {
		this.telephone_number = telephone_number;
	}


	public Rank getCustomer_rank() {
		return customer_rank;
	}


	public void setCustomer_rank(Rank customer_rank) {
		this.customer_rank = customer_rank;
	}
	
	
	
	
	
	

}
