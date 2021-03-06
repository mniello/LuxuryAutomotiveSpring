package com.luxuryautomotive.lab.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
@NamedQueries({
	@NamedQuery(name ="getNbaByDealerCustomer", query = "select n from Nba n where exists(select o from Order o where o.order_id = n.order_id and o.dealer_email=:email and o.customer_id =:customer_id) ORDER BY n.conversion_rate DESC"),
	@NamedQuery(name ="getNbaByDealer", query = "select n from Nba n, Order o where o.order_id = n.order_id and o.dealer_email=:email ORDER BY n.conversion_rate DESC"),
	@NamedQuery(name ="getNbaByDealerStatus", query = "select n from Nba n, Order o where o.order_id = n.order_id and n.status=:status and o.dealer_email=:email ORDER BY n.conversion_rate DESC"),
	@NamedQuery(name ="getNbaByDealerCustomerStatus", query = "select n from Nba n where exists(select o from Order o where o.order_id = n.order_id and n.status=:status and o.dealer_email=:email and o.customer_id =:customer_id) ORDER BY n.conversion_rate DESC"),
	@NamedQuery(name ="getNbaByDealerCustomerCategory", query = "select n from Nba n where exists(select o from Order o where o.order_id = n.order_id and n.category=:category and o.dealer_email=:email and o.customer_id =:customer_id) ORDER BY n.conversion_rate DESC"),
	@NamedQuery(name ="getNbaByDealerCustomerCategoryStatus", query = "select n from Nba n where exists(select o from Order o where o.order_id = n.order_id and n.category=:category and o.dealer_email=:email and o.customer_id =:customer_id and n.status=:status) ORDER BY n.conversion_rate DESC"),
	@NamedQuery(name ="getNbaById", query="select n from Nba n where n.nba_id=:nba_id"),
})
public class Nba {
	
	@Id
	private String nba_id;
	private String order_id;
	private String area;
	private Float conversion_rate;
	@Column(name = "status_")
	private String status;
	private String feedback;
	private Date creation_date;
	private Date closure_date;
	private String category;
	private Float priority;
	private Float opportunity_value;
	
	public Nba(String nba_id, String order_id, String area, Float conversion_rate, String status, String feedback, Date creation_date,
			Date closure_date, String category, Float priority, Float opportunity_value) {
		super();
		this.nba_id = nba_id;
		this.order_id = order_id;
		this.area = area;
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
		return "Nba [nba_id=" + nba_id + ", order_id=" + order_id + ", area=" + area + ", aftersale_category=" + conversion_rate + ", status=" + status + ", feedback=" + feedback
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

	public Float getConversion_rate() {
		return conversion_rate;
	}

	public void setConversion_rate(Float conversion_rate) {
		this.conversion_rate = conversion_rate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
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
