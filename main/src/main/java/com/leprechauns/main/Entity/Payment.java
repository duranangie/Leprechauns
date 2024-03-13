package com.leprechauns.main.Entity;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "pago")
public class Payment {

    @Id

    @Column(name = "id_transaccion") 
    private String transactionId;

    @Column(name = "forma_pago")
    private String paymentForm;

    @Column(name = "total")
    private Double total;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_pago")
    private Date payDay;

    @ManyToOne
    @JoinColumn(name = "codigo_cliente")
    private Customer customer;

    public Payment(Customer customer, String transactionId, String paymentForm, Double total, Date payDay) {
        this.customer = customer;
        this.transactionId = transactionId;
        this.paymentForm = paymentForm;
        this.total = total;
        this.payDay = payDay;
    }

    public Payment() {

    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getPayDay() {
        return payDay;
    }

    public void setPayDay(Date payDay) {
        this.payDay = payDay;
    }

    @Override
    public String toString() {
        return "Payment [customer=" + customer + ", transactionId=" + transactionId + ", paymentForm=" + paymentForm
                + ", total=" + total + ", payDay=" + payDay + "]";
    }

}
