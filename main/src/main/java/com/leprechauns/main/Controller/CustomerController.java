package com.leprechauns.main.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    // @GetMapping("/clientspay2008")
    // public List<Integer> findCustomerPayIn2008() {
    // return customerService.findCustomerPayIn2008();
    // }

    @GetMapping("/clientsInMadrid")
    public List<CustomerDTO> findCustomersMadrid() {
        return customerService.findCustomersMadrid();
    };

    @GetMapping("/customerspain")
    public List<CustomerDTO> findNameSpain() {
        return customerService.findNameSpain();
    };

    @GetMapping("/sales-info")
    public List<Object[]> clientsSalesRepresentatives() {
        return customerService.clientsSalesRepresentatives();
    }

    @GetMapping("/clientsSales")
    public List<Map<Object, Object>> clientsWithoutPaymentsAndRepresentatives() {
        return customerService.clientsWithoutPaymentsAndRepresentatives();
    }

    @GetMapping("/clientecity")
    public List<Map<Object, Object>> getCityCustomer() {
        return customerService.getCityCustomer();
    }

    @GetMapping("/clientsoffice-city")
    public List<Map<Object, Object>> clientsWithPaymentsOfficeCity() {
        return customerService.clientsWithPaymentsOfficeCity();
    }

    @GetMapping("/clientslate-deliveries")
    public List<String> clientsWithLateDeliveries() {
        return customerService.clientsWithLateDeliveries();
    }


    @GetMapping("/list-gamas")
    public List<Map<Object, Object>> listProductRangesByCustomer(){
        return customerService.listProductRangesByCustomer();
    }


    @GetMapping("/clientswithoutpayments")
    public List<CustomerDTO> clientsWithoutPayments() {
        return customerService.clientsWithoutPayments();
    }


    @GetMapping("/clients-without-orders")
    public List<CustomerDTO> clientsWithoutOrders() {
        return customerService.clientsWithoutOrders();
    }

    @GetMapping("/clients-without-paymentsorders")
    public List<CustomerDTO> clientsWithoutPaymentsAndOrders() {
        return customerService.clientsWithoutPaymentsAndOrders();
    }


    @GetMapping("/clients-with-orders-but-no-payments")
    public List<CustomerDTO> clientsWithOrdersButNoPayments() {
        return customerService.clientsWithOrdersButNoPayments();
    }

    @GetMapping("/clients-count-by-country")
    public List<Map<Object, Object>> clientsCountByCountry() {
        return customerService.clientsCountByCountry();
    }


      @GetMapping("/clients-count-city/{city}")
    public int clientsCountInCity(@PathVariable String city) {
        return customerService.clientsCountInCity(city);
    }


    @GetMapping("/clients-count-in-cities-starting-with-M")
    public List<Map<Object, Object>> clientsCountInCitiesStartingWithM() {
        return customerService.clientsCountInCitiesStartingWithM();
    }

    @GetMapping("/clientrepresentative")
    public int clientsWithoutSales() {
        return customerService.clientsWithoutSales();
    }


    @GetMapping("/first-last-payment-date-by-client")
    public List<Map<Object, Object>> firstLastPaymentDateByClient() {
        return customerService.firstLastPaymentDateByClient();
    }

}