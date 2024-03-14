package com.leprechauns.main.Entity;

import java.sql.Date;

import com.leprechauns.main.DTO.PaymentDTO;

import jakarta.persistence.*;

@Entity
@Table(name = "pago")
public class Payment {

    @Id
    @Column(name = "id_transaccion", nullable = false)
    private String transactionId;

    @Column(name = "forma_pago", nullable = false)
    private String paymentForm;

    @Column(name = "total", nullable = false)
    private double total;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_pago", nullable = false)
    private Date payDay;

    @ManyToOne
    @JoinColumn(name = "codigo_cliente")
    private Customer customer;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getPaymentForm() {
        return paymentForm;
    }

    public void setPaymentForm(String paymentForm) {
        this.paymentForm = paymentForm;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getPayDay() {
        return payDay;
    }

    public void setPayDay(Date payDay) {
        this.payDay = payDay;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /* DTO */

    public PaymentDTO toDTO() {
        PaymentDTO dto = new PaymentDTO();
        dto.setTransactionId(this.transactionId);
        dto.setPaymentForm(this.paymentForm);
        dto.setPayDay(this.payDay);
        dto.setTotal(this.total);
        dto.setCustomer(this.customer != null ? this.customer.getCustomerId() : null);
        return dto;
    }

    @Override
    public String toString() {
        return "Payment [transactionId=" + transactionId + ", paymentForm=" + paymentForm + ", total=" + total
                + ", payDay=" + payDay + ", customer=" + customer + "]";
    }

}
