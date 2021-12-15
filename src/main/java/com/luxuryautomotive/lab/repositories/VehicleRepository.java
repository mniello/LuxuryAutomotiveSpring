package com.luxuryautomotive.lab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luxuryautomotive.lab.domain.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {

}
