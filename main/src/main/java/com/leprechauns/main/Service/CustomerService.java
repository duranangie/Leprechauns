package com.leprechauns.main.Service;

import com.leprechauns.main.Entity.Customer;
import com.leprechauns.main.Entity.DTO.CustomerDTO;
import com.leprechauns.main.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(Customer::toDTO)
                .toList();
    }


    public List<CustomerDTO> findByCountryLikeIgnoreCase() {
        return customerRepository.findByCountryLikeIgnoreCase("spain").stream()
                .map(Customer::toDTO)
                .toList();
    }

    public List<Integer> findCustomerPayIn2008() {
        return customerRepository.findCustomerPayIn2008();
    }

    // public List<CustomerDTO> findCustomersMadrid() {
    //     return customerRepository.findCustomersMadrid().stream()
    //             .map(Customer::toDTO)
    //             .toList();
    // };
}