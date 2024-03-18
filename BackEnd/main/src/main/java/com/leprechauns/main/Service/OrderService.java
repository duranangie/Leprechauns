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

    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(Order::toDTO)
                .toList();
    }

    public List<String> getOrderStatus() {
        return orderRepository.getOrderStatus();
    }

    public List<Object> findOrdersByExpectedDeliveryBeforeActual() {
        return orderRepository.findOrdersByExpectedDeliveryBeforeActual();
    }

    public List<Object[]> findDay() {
        return orderRepository.findDay();
    }

    public List<Object[]> findOrders(int year) {
        return orderRepository.findOrders(year);
    }

    public List<Object> findOrdersInJanuary(String deadline) {
        return orderRepository.findOrdersInJanuary(deadline);
    }

    public List<Object[]> countByEstado() {
        return orderRepository.countByEstado();
    }
}