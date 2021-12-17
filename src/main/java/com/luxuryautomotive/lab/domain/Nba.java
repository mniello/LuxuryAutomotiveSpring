package com.luxuryautomotive.lab.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class Nba {
	
	public enum Status{
		ACCEPTED,
		REJCTED,
		ACTIVE,
		NOT_ACTIVE,
		FINALIZED
		}
	
	@Id
	private String nba_id;
	private String order_id;
	private String area;
	private String nba_code;
	private String aftersale_id;
	private String aftersale_categoryl;
	private Float conversion_rate;
	private Status status;
	private String feedback;
	private Date creation_date;
	private Date closure_date;
	private String category;
	private Float priority;
	private Float opportunity_value;
	
	public Nba(String nba_id, String order_id, String area, String nba_code, String aftersale_id,
			String aftersale_categoryl, Float conversion_rate, Status status, String feedback, Date creation_date,
			Date closure_date, String category, Float priority, Float opportunity_value) {
		super();
		this.nba_id = nba_id;
		this.order_id = order_id;
		this.area = area;
		this.nba_code = nba_code;
		this.aftersale_id = aftersale_id;
		this.aftersale_categoryl = aftersale_categoryl;
		this.conversion_rate = conversion_rate;
		this.status = status;
		this.feedback = feedback;
		this.creation_date = creation_date;
		this.closure_date = closure_date;
		this.category = category;
		this.priority = priority;
		this.opportunity_value = opportunity_value;
	}

	public Nba() {
		super();
	}

	@Override
	public String toString() {
		return "Nba [nba_id=" + nba_id + ", order_id=" + order_id + ", area=" + area + ", nba_code=" + nba_code
				+ ", aftersale_id=" + aftersale_id + ", aftersale_categoryl=" + aftersale_categoryl
				+ ", conversion_rate=" + conversion_rate + ", status=" + status + ", feedback=" + feedback
				+ ", creation_date=" + creation_date + ", closure_date=" + closure_date + ", category=" + category
				+ ", priority=" + priority + ", opportunity_value=" + opportunity_value + "]";
	}

	public String getNba_id() {
		return nba_id;
	}

	public void setNba_id(String nba_id) {
		this.nba_id = nba_id;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getNba_code() {
		return nba_code;
	}

	public void setNba_code(String nba_code) {
		this.nba_code = nba_code;
	}

	public String getAftersale_id() {
		return aftersale_id;
	}

	public void setAftersale_id(String aftersale_id) {
		this.aftersale_id = aftersale_id;
	}

	public String getAftersale_categoryl() {
		return aftersale_categoryl;
	}

	public void setAftersale_categoryl(String aftersale_categoryl) {
		this.aftersale_categoryl = aftersale_categoryl;
	}

	public Float getConversion_rate() {
		return conversion_rate;
	}

	public void setConversion_rate(Float conversion_rate) {
		this.conversion_rate = conversion_rate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public Date getClosure_date() {
		return closure_date;
	}

	public void setClosure_date(Date closure_date) {
		this.closure_date = closure_date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Float getPriority() {
		return priority;
	}

	public void setPriority(Float priority) {
		this.priority = priority;
	}

	public Float getOpportunity_value() {
		return opportunity_value;
	}

	public void setOpportunity_value(Float opportunity_value) {
		this.opportunity_value = opportunity_value;
	}
	
	
	

}
