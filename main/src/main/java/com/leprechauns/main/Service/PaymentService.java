package com.leprechauns.main.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leprechauns.main.DTO.PaymentDTO;
import com.leprechauns.main.Entity.Payment;
import com.leprechauns.main.Repository.PaymentRepository;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<PaymentDTO> getALllPayments() {
        return paymentRepository.findAll().stream()
                .map(Payment::toDTO)
                .toList();
    }
}