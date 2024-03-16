package com.leprechauns.main.Service;

import com.leprechauns.main.Entity.ChanceList;
import com.leprechauns.main.Entity.Customer;
import com.leprechauns.main.Entity.DTO.CustomerDTO;
import com.leprechauns.main.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

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

    // public List<Integer> findCustomerPayIn2008() {
    //     return customerRepository.findCustomerPayIn2008();
    // }

    public List<CustomerDTO> findCustomersMadrid() {
        return customerRepository.findCustomersMadrid().stream()
                .map(Customer::toDTO)
                .toList();
    };


    public List<CustomerDTO> findNameSpain(){
        return customerRepository.findNameSpain().stream()
        .map(Customer::toDTO)
        .toList();
    }


    public List<Object[]> clientsSalesRepresentatives() {
        return customerRepository.clientsSalesRepresentatives();
    }


    public List<Map<Object, Object>> clientsWithoutPaymentsAndRepresentatives() {
        List<Object[]> results = customerRepository.clientsWithoutPaymentsAndRepresentatives();;
        return ChanceList.chanceList(results, "customerId", "customerName", "sales");
    }

    public List<Map<Object, Object>> getCityCustomer() {
        List<Object[]> results = customerRepository.getCityCustomer();
        return ChanceList.chanceList(results, "customerId", "customerName", "sales", "officeCity");
    }

    public List<Map<Object, Object>> clientsWithPaymentsOfficeCity() {
        List<Object[]> results = customerRepository.clientsWithPaymentsOfficeCity();
        return ChanceList.chanceList(results, "customerCode", "customerName", "repSalesName", "officeCity");
    }


    public List<String> clientsWithLateDeliveries() {
        return customerRepository.clientsWithLateDeliveries();
    }


    public List<Map<Object, Object>> listProductRangesByCustomer() {
        List<Object[]> results = customerRepository.listProductRangesByCustomer();
        return ChanceList.chanceList(results, "customerName", "gama");
    }


    public List<CustomerDTO> clientsWithoutPayments() {
        return customerRepository.clientsWithoutPayments().stream()
                .map(Customer::toDTO)
                .toList();
    }

    public List<CustomerDTO> clientsWithoutOrders() {
        return customerRepository.clientsWithoutOrders().stream()
                .map(Customer::toDTO)
                .toList();
    }


    public List<CustomerDTO> clientsWithoutPaymentsAndOrders() {
        return customerRepository.clientsWithoutPaymentsAndOrders().stream()
                .map(Customer::toDTO)
                .toList();
    }

    public List<CustomerDTO> clientsWithOrdersButNoPayments() {
        return customerRepository.clientsWithOrdersButNoPayments().stream()
                .map(Customer::toDTO)
                .toList();
    }   


    public List<Map<Object, Object>> clientsCountByCountry() {
        List<Object[]> results = customerRepository.clientsCountByCountry();
        return ChanceList.chanceList(results, "country", "customers");
    }

    public int totalClients() {
        return customerRepository.totalClients();
    }


    public int clientsCountInCity(String city) {
        return customerRepository.clientsCountInCity(city);
    }


    public List<Map<Object, Object>> clientsCountInCitiesStartingWithM() {
        List<Object[]> results = customerRepository.clientsCountInCitiesStartingWithM();
        return ChanceList.chanceList(results, "country", "customers");
    }


    public int clientsWithoutSales() {
        return customerRepository.clientsWithoutSales();
    }



      public List<Map<Object, Object>> firstLastPaymentDateByClient() {
        List<Object[]> results = customerRepository.firstLastPaymentDateByClient();
        return ChanceList.chanceList(results, "customerCode", "customerName", "contactName", "firstPayment", "lastPayment");
    }



    
}