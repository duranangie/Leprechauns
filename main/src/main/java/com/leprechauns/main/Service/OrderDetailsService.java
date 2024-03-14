package com.leprechauns.main.Service;

import com.leprechauns.main.Entity.DTO.OrderDetailsDTO;
import com.leprechauns.main.Entity.oderdetails.OrderDetails;
import com.leprechauns.main.Repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsService {

       @Autowired
    public OrderDetailsRepository orderDetailRepository;

    public List<OrderDetailsDTO> getAllOrderDetails() {
        return orderDetailRepository.findAll().stream()
                .map(OrderDetails::toDTO)
                .toList();
    }
}