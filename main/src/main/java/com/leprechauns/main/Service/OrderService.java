package com.leprechauns.main.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leprechauns.main.Entity.Order;
import com.leprechauns.main.Repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    public OrderRepository orderRepository;

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }
}