package com.luxuryautomotive.lab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luxuryautomotive.lab.domain.PaymentMethod;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, String> {

}
