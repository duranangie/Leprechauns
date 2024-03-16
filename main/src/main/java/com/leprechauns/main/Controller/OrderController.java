package com.leprechauns.main.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leprechauns.main.Entity.DTO.OrderDTO;
import com.leprechauns.main.Service.OrderService;

@RestController
@RequestMapping("/orders")
@CrossOrigin("*")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderDTO> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/orderstatus")
    public List<String> getOrderStatus(){
        return orderService.getOrderStatus();
    }

    @GetMapping("/deliver")
    public List<Object> findOrdersByExpectedDeliveryBeforeActual() {
        return orderService.findOrdersByExpectedDeliveryBeforeActual(); 
    }

    @GetMapping("/deliverbefore")
    public List<Object[]> findDay() {
        return orderService.findDay();
    }

    @GetMapping("/rejected")
    public List<Object[]> findOrders() {
        return orderService.findOrders();
    }

    @GetMapping("/january-delivered")
    public List<Object> getJanuaryDeliveredOrders() {
        return orderService.findOrdersInJanuary();
    }

    @GetMapping("/count")
    public List<Object[]> countByEstado() {
        return orderService.countByEstado();
    }
}