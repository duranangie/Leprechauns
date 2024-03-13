package com.leprechauns.main.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="oficina")
public class Office {
    @Id
  
    @Column(name="codigo_oficina")
    private String office_code;
    @Column(name="ciudad")
    private String city;
    @Column(name="pais")
    private String country;
    @Column(name="region")
    private String region;
    @Column(name="codigo_postal")
    private String postalCode;
    @Column(name="telefono")
    private String phone;
    @Column(name="linea_direccion1")
    private String address1;
    @Column(name="linea_direccion2")
    private String address2;


    @OneToMany(mappedBy = "empleado" , cascade =CascadeType.ALL , orphanRemoval = true , fetch = FetchType.LAZY)
    private List<Employee> employees = new ArrayList<>();


    public Office(String office_code, String city, String country, String region, String postalCode, String phone,
            String address1, String address2, List<Employee> employee) {
        this.office_code = office_code;
        this.city = city;
        this.country = country;
        this.region = region;
        this.postalCode = postalCode;
        this.phone = phone;
        this.address1 = address1;
        this.address2 = address2;
        this.employee = employee;
    }
    

    public Office(){

    }


    public String getOffice_code() {
        return office_code;
    }


    public void setOffice_code(String office_code) {
        this.office_code = office_code;
    }


    public String getCity() {
        return city;
    }


    public void setCity(String city) {
        this.city = city;
    }


    public String getCountry() {
        return country;
    }


    public void setCountry(String country) {
        this.country = country;
    }


    public String getRegion() {
        return region;
    }


    public void setRegion(String region) {
        this.region = region;
    }


    public String getPostalCode() {
        return postalCode;
    }


    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }


    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getAddress1() {
        return address1;
    }


    public void setAddress1(String address1) {
        this.address1 = address1;
    }


    public String getAddress2() {
        return address2;
    }


    public void setAddress2(String address2) {
        this.address2 = address2;
    }


    public List<Employee> getEmployee() {
        return employee;
    }


    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }


    @Override
    public String toString() {
        return "Office [office_code=" + office_code + ", city=" + city + ", country=" + country + ", region=" + region
                + ", postalCode=" + postalCode + ", phone=" + phone + ", address1=" + address1 + ", address2="
                + address2 + ", employee=" + employee + "]";
    }

    


    
}
