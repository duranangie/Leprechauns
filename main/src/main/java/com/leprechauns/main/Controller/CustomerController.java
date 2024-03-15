package com.leprechauns.main.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leprechauns.main.Entity.DTO.CustomerDTO;
import com.leprechauns.main.Service.CustomerService;

@RestController
@RequestMapping("/customers")
@CrossOrigin("*")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/customersCountry")
    public List<CustomerDTO> findByCountryLikeIgnoreCase() {
        return customerService.findByCountryLikeIgnoreCase();
    }

    @GetMapping("/clientspay2008")
    public List<Integer> findCustomerPayIn2008() {
        return customerService.findCustomerPayIn2008();
    }














    

    // @GetMapping("/clientsInMadrid")
    // public List<CustomerDTO> findCustomersMadrid() {
    //     return customerService.findCustomersMadrid();
    // };

    
}