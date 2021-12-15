package com.luxuryautomotive.lab.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class Dealer {
	@Id
	private String dealer_email;
	private String password;
	private String first_name;
	private String last_name;
	private String company;
	private String region;
	private String country;
	
	public Dealer(String dealer_email, String password, String first_name, String last_name, String company,
			String region, String country) {
		super();
		this.dealer_email = dealer_email;
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.company = company;
		this.region = region;
		this.country = country;
	}

	public Dealer() {
		super();
	}

	
	@Override
	public String toString() {
		return "Dealer [dealer_email=" + dealer_email + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", company=" + company + ", region=" + region + ", country=" + country + "]";
	}

	public String getDealer_email() {
		return dealer_email;
	}

	public void setDealer_email(String dealer_email) {
		this.dealer_email = dealer_email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
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
	
	
	
	

}
