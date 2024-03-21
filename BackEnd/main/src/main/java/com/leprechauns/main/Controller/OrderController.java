package com.leprechauns.main.Controller;

import java.util.List;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leprechauns.main.Entity.DTO.OrderDTO;
import com.leprechauns.main.Service.OrderService;

@RestController
@RequestMapping("/orders")
@CrossOrigin("*")
@PreAuthorize("hasRole('ADMIN')")
@SecurityRequirement(name = "bearerAuth")
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

    @GetMapping("/rejected/{year}")
    public List<Object[]> findOrders(@PathVariable int year) {
        return orderService.findOrders(year);
    }

    @GetMapping("/january-delivered/{deadline}")
    public List<Object> getJanuaryDeliveredOrders(@PathVariable String deadline) {
        return orderService.findOrdersInJanuary(deadline);
    }

    @GetMapping("/count")
    public List<Object[]> countByEstado() {
        return orderService.countByEstado();
    }
}