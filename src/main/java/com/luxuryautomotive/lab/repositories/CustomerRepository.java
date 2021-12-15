package com.luxuryautomotive.lab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luxuryautomotive.lab.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
