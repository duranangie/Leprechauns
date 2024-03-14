package com.leprechauns.main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leprechauns.main.Entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}