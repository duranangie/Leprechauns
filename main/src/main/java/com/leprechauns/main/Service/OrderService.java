package com.leprechauns.main.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leprechauns.main.Entity.Order;
import com.leprechauns.main.Entity.DTO.OrderDTO;
import com.leprechauns.main.Repository.OrderRepository;

@Service
public class OrderService {


    public final OrderRepository orderRepository;
    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderDTO> getAllOrders(){

        return orderRepository.findAll().stream()
                .map(Order::toDTO)
                .toList();
    }
}