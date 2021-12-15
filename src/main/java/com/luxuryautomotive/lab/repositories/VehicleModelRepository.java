package com.luxuryautomotive.lab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luxuryautomotive.lab.domain.VehicleModel;

public interface VehicleModelRepository extends JpaRepository<VehicleModel, String> {

}
