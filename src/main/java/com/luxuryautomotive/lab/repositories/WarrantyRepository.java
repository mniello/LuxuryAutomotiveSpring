package com.luxuryautomotive.lab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luxuryautomotive.lab.domain.Warranty;

public interface WarrantyRepository extends JpaRepository<Warranty, String> {

}
