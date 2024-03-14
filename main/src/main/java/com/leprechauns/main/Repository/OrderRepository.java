package com.leprechauns.main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leprechauns.main.Entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}