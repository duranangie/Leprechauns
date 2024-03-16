package com.leprechauns.main.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leprechauns.main.Entity.DTO.OrderDetailsDTO;
import com.leprechauns.main.Service.OrderDetailsService;

@RestController
@RequestMapping("/orderdetails")
@CrossOrigin("*")
public class OrderDetailsController {

    public final OrderDetailsService orderDetailsService;

     @Autowired
    public OrderDetailsController(OrderDetailsService orderDetailService) {
        this.orderDetailsService = orderDetailService;
    }
    @GetMapping
    public List<OrderDetailsDTO> getAllOrderDetails(){
        return orderDetailsService.getAllOrderDetails();
    }

    // @GetMapping("/different-products")
    // public ResponseEntity<List<OrderDetailsDTO>> findNumberProduct() {
    //     List<OrderDetailsDTO> orderDetailsDTOList = orderDetailsService.findNumberProduct();
    //     return ResponseEntity.ok(orderDetailsDTOList);
    // }
    
}
