package com.leprechauns.main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leprechauns.main.Entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {
}