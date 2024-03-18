package com.leprechauns.main.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leprechauns.main.Entity.Payment;
import com.leprechauns.main.Entity.DTO.PaymentDTO;
import com.leprechauns.main.Service.PaymentService;

@RestController
@RequestMapping("/payments")
@CrossOrigin("*")
public class PaymentController {
    
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public List<PaymentDTO> getAllPayments(){
        return paymentService.getALllPayments();
    }
    
    @GetMapping("/customer-with-payment-2008")
    public List<Integer> getCustomerPayment2008(){
        return paymentService.findCustomerPayment2008();
    }

    @GetMapping("/payment-2008-paypal")
    public List<Payment> getPayments2008PayPal(){
        return paymentService.findPayments2008PayPal();
    }

    @GetMapping("/payment-form")
    public List<String> getPaymentForm(){
        return paymentService.findPaymentForm();
    }

    @GetMapping("/paying-customer-sales-person")
    public List<Map<String, Object>> getPayingCustomerSalesEmployee(){
        return paymentService.findPayingCustomerSalesEmployee();
    }

    @GetMapping("/paying-customer-sales-person-with-city")
    public List<Map<String, Object>> getPayingCustomerSalesEmployeeWithOffice(){
        return paymentService.findPayingCustomerSalesEmployeeWithOffice();
    }

    @GetMapping("/average-payment-2009")
    public List<Double> getAveragePayment(){
        return paymentService.findAveragePayment();
    }

    @GetMapping("/total-payments-per-year")
    public List<Map<String, Object>> getTotalPaymentPerYear(){
        return paymentService.findTotalPaymentPerYear();
    }
}
