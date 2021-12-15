package com.luxuryautomotive.lab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luxuryautomotive.lab.domain.Order;

public interface OrderRepository extends JpaRepository<Order, String>{

}
