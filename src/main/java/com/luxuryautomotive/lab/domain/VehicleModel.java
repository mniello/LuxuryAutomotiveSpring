package com.luxuryautomotive.lab.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class VehicleModel {
	
	@Id
	private String model_id;
	private String model_name;
	private String description;
	private Integer year_of_release;
	private String car_make;
	
	public VehicleModel(String model_id, String model_name, String description, Integer year_of_release, String car_make) {
		super();
		this.model_id = model_id;
		this.model_name = model_name;
		this.description = description;
		this.year_of_release = year_of_release;
		this.car_make = car_make;
	}

	public VehicleModel() {
		super();
	}

	@Override
	public String toString() {
		return "VehicleModel [model_id=" + model_id + ", model_name=" + model_name + ", description="
				+ description + ", year_of_release=" + year_of_release + ", car_make="+ car_make + "]";
	}

	public String getCar_make() {
		return car_make;
	}

	public void setCar_make(String car_make) {
		this.car_make = car_make;
	}

	public String getModel_id() {
		return model_id;
	}

	public void setModel_id(String model_id) {
		this.model_id = model_id;
	}

	public String getModel_name() {
		return model_name;
	}

	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getYear_of_release() {
		return year_of_release;
	}

	public void setYear_of_release(Integer year_of_release) {
		this.year_of_release = year_of_release;
	}
	
	
	
}
