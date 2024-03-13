package com.leprechauns.main.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codigo_cliente")
    private Long customerId;

    @Column(name="nombre_cliente")
    private String customerName;
    @Column(name="nombre_contacto")
    private String contactName;
    @Column(name="apellido_contacto")
    private String contactLastName;
    @Column(name="telefono")
    private String phoneNumber;
    @Column(name="fax")
    private String fax;
    @Column(name="linea_direccion1")
    private String lineAddress1;
    @Column(name="linea_direccion2")
    private String lineAddress2;
    @Column(name="ciudad")
    private String city;
    @Column(name="region")
    private String region;
    @Column(name="pais")
    private String country;
    @Column(name="codigo_postal")
    private String postalCode;
    @Column(name="limite_credito")
    private Double creditLimit;
    // RELATION MANY TO ONE WITH THE TABLE "empleado"
    @Column(name="codigo_empleado_rep_ventas")
    private Long salesRepresentativeCode;

    @OneToMany (mappedBy = "cliente", cascade =CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Payment> payments = new ArrayList<>();

    public Customer() {
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
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

    public Long getSalesRepresentativeCode() {
        return salesRepresentativeCode;
    }

    public void setSalesRepresentativeCode(Long salesRepresentativeCode) {
        this.salesRepresentativeCode = salesRepresentativeCode;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        return Objects.equals(getCustomerId(), customer.getCustomerId()) && Objects.equals(getCustomerName(), customer.getCustomerName()) && Objects.equals(getContactName(), customer.getContactName()) && Objects.equals(getContactLastName(), customer.getContactLastName()) && Objects.equals(getPhoneNumber(), customer.getPhoneNumber()) && Objects.equals(getFax(), customer.getFax()) && Objects.equals(getLineAddress1(), customer.getLineAddress1()) && Objects.equals(getLineAddress2(), customer.getLineAddress2()) && Objects.equals(getCity(), customer.getCity()) && Objects.equals(getRegion(), customer.getRegion()) && Objects.equals(getCountry(), customer.getCountry()) && Objects.equals(getPostalCode(), customer.getPostalCode()) && Objects.equals(getCreditLimit(), customer.getCreditLimit()) && Objects.equals(getSalesRepresentativeCode(), customer.getSalesRepresentativeCode()) && Objects.equals(getPayments(), customer.getPayments());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerId(), getCustomerName(), getContactName(), getContactLastName(), getPhoneNumber(), getFax(), getLineAddress1(), getLineAddress2(), getCity(), getRegion(), getCountry(), getPostalCode(), getCreditLimit(), getSalesRepresentativeCode(), getPayments());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", contactName='" + contactName + '\'' +
                ", contactLastName='" + contactLastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", fax='" + fax + '\'' +
                ", lineAddress1='" + lineAddress1 + '\'' +
                ", lineAddress2='" + lineAddress2 + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", creditLimit=" + creditLimit +
                ", salesRepresentativeCode=" + salesRepresentativeCode +
                ", payments=" + payments +
                '}';
    }
}
