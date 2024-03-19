package com.leprechauns.main.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import com.leprechauns.main.Entity.Payment;
import com.leprechauns.main.Entity.DTO.PaymentDTO;
import com.leprechauns.main.Exceptions.NotFoundEndPoint;
import com.leprechauns.main.Repository.PaymentRepository;

@Service
public class PaymentService {
    
    private final PaymentRepository paymentRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<PaymentDTO> getALllPayments() {
        return paymentRepository.findAll().stream()
                .map(Payment::toDTO)
                .toList();
    }

    public List<Integer> findCustomerPayment2008(int year) {
        String yearStr = String.valueOf(year);
        if (yearStr.length() != 4) {
            throw new IllegalArgumentException("The year must be exactly 4 digits");
        }
        return paymentRepository.findCustomerPayment2008(year);
    }

    public List<Payment> findPayments2008PayPal(int year, String paymentForm) {
        String yearStr = String.valueOf(year);
        boolean existsByPaymentForm = paymentRepository.existsByPaymentForm(paymentForm);
        if (yearStr.length() != 4) {
            throw new IllegalArgumentException("The year must be exactly 4 digits");
        }
        if(!existsByPaymentForm){
            throw new NotFoundEndPoint("We don't have that kind of payment form");
        }
        return paymentRepository.findPayments2008PayPal(year, paymentForm);
    }

    public List<String> findPaymentForm() {
        return paymentRepository.findPaymentForm();
    }

    public List<Map<String, Object>> findPayingCustomerSalesEmployee() {
        return paymentRepository.findPayingCustomerSalesEmployee();
    }

    public List<Map<String, Object>> findPayingCustomerSalesEmployeeWithOffice() {
        return paymentRepository.findPayingCustomerSalesEmployeeWithOffice();
    }

    public List<Double> findAveragePayment(int year) {
        String yearStr = String.valueOf(year);
        if (yearStr.length() != 4) {
            throw new IllegalArgumentException("The year must be exactly 4 digits");
        }
        return paymentRepository.findAveragePayment(year);
    }

    public List<Map<String, Object>> findTotalPaymentPerYear() {
        return paymentRepository.findTotalPaymentPerYear();
    }
}