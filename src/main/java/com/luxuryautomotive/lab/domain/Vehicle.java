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
	@NamedQuery(name ="getVehicleByModelId", query = "select v from Vehicle v where v.model_id=:model"),
})
public class Vehicle  {

	@Id
	private String vin;
	private String car_plate;
	private String outfitting;
	private Boolean ownership;
	private Date start_ownership_date;
	private Date end_ownership_date;
	private String model_id;

	public Vehicle(String vin, String car_plate, String outfitting, Boolean ownership,
			Date start_ownership_date, Date end_ownership_date, String model_id) {
		super();
		this.vin = vin;
		this.car_plate = car_plate;
		this.outfitting = outfitting;
		this.ownership = ownership;
		this.start_ownership_date = start_ownership_date;
		this.end_ownership_date = end_ownership_date;
		this.model_id = model_id;
	}
	public Vehicle() {
		super();
	}
	@Override
	public String toString() {
		return "Vehicle [vin=" + vin + ", car_plate=" + car_plate + ", outfitting="
				+ outfitting + ", ownership=" + ownership + ", start_ownership_date=" + start_ownership_date
				+ ", end_ownership_date=" + end_ownership_date +", model_id="+model_id+ "]";
	}

	public String getModel_id() {
		return model_id;
	}

	public void setModel_id(String model_id) {
		this.model_id = model_id;
	}

	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getCar_plate() {
		return car_plate;
	}
	public void setCar_plate(String car_plate) {
		this.car_plate = car_plate;
	}
	public String getOutfitting() {
		return outfitting;
	}
	public void setOutfitting(String outfitting) {
		this.outfitting = outfitting;
	}
	public Boolean getOwnership() {
		return ownership;
	}
	public void setOwnership(Boolean ownership) {
		this.ownership = ownership;
	}
	public Date getStart_ownership_date() {
		return start_ownership_date;
	}
	public void setStart_ownership_date(Date start_ownership_date) {
		this.start_ownership_date = start_ownership_date;
	}
	public Date getEnd_ownership_date() {
		return end_ownership_date;
	}
	public void setEnd_ownership_date(Date end_ownership_date) {
		this.end_ownership_date = end_ownership_date;
	}
	
	
}
