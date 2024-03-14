package com.leprechauns.main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leprechauns.main.Entity.oderdetails.OrderDetailId;
import com.leprechauns.main.Entity.oderdetails.OrderDetails;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, OrderDetailId> {

}