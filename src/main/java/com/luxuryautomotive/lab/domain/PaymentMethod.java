package com.luxuryautomotive.lab.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class PaymentMethod {
	@Id
	private String payment_id;
	private String order_id;
	private String payment_type;
	public PaymentMethod(String payment_id, String order_id, String payment_type) {
		super();
		this.payment_id = payment_id;
		this.order_id = order_id;
		this.payment_type = payment_type;
	}
	public PaymentMethod() {
		super();
	}
	@Override
	public String toString() {
		return "PaymentMethod [payment_id=" + payment_id + ", order_id=" + order_id + ", payment_type=" + payment_type
				+ "]";
	}
	public String getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}

	
}
