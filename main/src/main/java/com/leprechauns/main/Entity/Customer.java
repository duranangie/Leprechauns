package com.leprechauns.main.Entity;

import jakarta.persistence.*;
import java.util.List;

import com.leprechauns.main.DTO.CustomerDTO;

@Entity
@Table(name = "cliente")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_cliente")
    private Integer customerId;

    @Column(name = "nombre_cliente", nullable = false)
    private String customerName;
    @Column(name = "nombre_contacto")
    private String contactName;
    @Column(name = "apellido_contacto")
    private String contactLastName;
    @Column(name = "telefono", nullable = false)
    private String phoneNumber;
    @Column(name = "fax", nullable = false)
    private String fax;
    @Column(name = "linea_direccion1", nullable = false)
    private String lineAddress1;
    @Column(name = "linea_direccion2")
    private String lineAddress2;
    @Column(name = "ciudad", nullable = false)
    private String city;
    @Column(name = "region")
    private String region;
    @Column(name = "pais")
    private String country;
    @Column(name = "codigo_postal")
    private String postalCode;
    @Column(name = "limite_credito")
    private Double creditLimit;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo_empleado_rep_ventas")
    private Employee sales;
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Payment> payments;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Order> orders;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getLineAddress1() {
        return lineAddress1;
    }

    public void setLineAddress1(String lineAddress1) {
        this.lineAddress1 = lineAddress1;
    }

    public String getLineAddress2() {
        return lineAddress2;
    }

    public void setLineAddress2(String lineAddress2) {
        this.lineAddress2 = lineAddress2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Employee getSales() {
        return sales;
    }

    public void setSales(Employee sales) {
        this.sales = sales;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    /* DTO */

       public CustomerDTO toDTO() {
        CustomerDTO dto = new CustomerDTO();
        dto.setCustomerId(this.customerId);
        dto.setCustomerName(this.customerName);
        dto.setContactName(this.contactName);
        dto.setContactLastName(this.contactLastName);
        dto.setPhoneNumber(this.phoneNumber);
        dto.setFax(this.fax);
        dto.setLineAddress1(this.lineAddress1);
        dto.setLineAddress2(this.lineAddress2);
        dto.setCity(this.city);
        dto.setRegion(this.region);
        dto.setCountry(this.country);
        dto.setPostalCode(this.postalCode);
        dto.setCreditLimit(this.creditLimit);
        dto.setSales(this.sales != null ? this.sales.getEmployeeId() : null);
        return dto;
       }

    @Override
    public String toString() {
        return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", contactName=" + contactName
                + ", contactLastName=" + contactLastName + ", phoneNumber=" + phoneNumber + ", fax=" + fax
                + ", lineAddress1=" + lineAddress1 + ", lineAddress2=" + lineAddress2 + ", city=" + city + ", region="
                + region + ", country=" + country + ", postalCode=" + postalCode + ", creditLimit=" + creditLimit
                + ", sales=" + sales + "]";
    }

}