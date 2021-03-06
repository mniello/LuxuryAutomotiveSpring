package com.luxuryautomotive.lab.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="order_")
@Data
@NamedQueries({
	@NamedQuery(name ="getOrderByDealer", query = "select o from Order o where o.dealer_email=:email"),
	@NamedQuery(name ="getOrderByCustomer", query = "select o from Order o where o.customer_id=:id"),
	@NamedQuery(name ="getOrderByVehicle", query = "select o from Order o where o.vin=:vin")
})
public class Order {

	@Id
	private String order_id;
	private String customer_id;
	private String dealer_email;
	private String order_type;
	private Date date;
	private float price;
	private String payment_type;
	private String vin;
	
	
	public Order(String order_id, String customer_id, String dealer_email, String order_type, Date date,
			float price, String payment_type , String vin) {
		super();
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.dealer_email = dealer_email;
		this.order_type = order_type;
		this.date = date;
		this.price = price;
		this.payment_type = payment_type;
		this.vin = vin;
	}


	public Order() {
		super();
	}


	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", customer_id=" + customer_id + ", dealer_email=" + dealer_email
				+ ", order_type=" + order_type + ", date=" + date + ", price=" + price + ", payment_type="+ payment_type+ ", vin="+vin + "]" ;
	}


	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}

	public String getOrder_id() {
		return order_id;
	}


	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}


	public String getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}


	public String getDealer_email() {
		return dealer_email;
	}


	public void setDealer_email(String dealer_email) {
		this.dealer_email = dealer_email;
	}


	public String getOrder_type() {
		return order_type;
	}


	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}
	
	
	
}
