package com.leprechauns.main.Entity;

import java.util.List;

import com.leprechauns.main.Entity.DTO.OfficeDTO;

import jakarta.persistence.*;

@Entity
@Table(name = "oficina")
public class Office {
        @Id
        @Column(name = "codigo_oficina", nullable = false)
        private String officeCode;

        @Column(name = "ciudad", nullable = false)
        private String city;

        @Column(name = "pais", nullable = false)
        private String country;

        @Column(name = "region")
        private String region;

        @Column(name = "codigo_postal", nullable = false)
        private String postalCode;

        @Column(name = "telefono", nullable = false)
        private String phone;

        @Column(name = "linea_direccion1", nullable = false)
        private String address1;

        @Column(name = "linea_direccion2")
        private String address2;

    @OneToMany(mappedBy = "office", cascade = CascadeType.ALL)
    private List<Employee> employees;

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    /* DTO */

      public OfficeDTO toDTO() {
        OfficeDTO dto = new OfficeDTO();
        dto.setOfficeCode(this.officeCode);
        dto.setCity(this.city);
        dto.setCountry(this.country);
        dto.setRegion(this.region);
        dto.setPostalCode(this.postalCode);
        dto.setPhone(this.phone);
        dto.setAddressLine1(this.address1);
        dto.setAddressLine2(this.address2);
        return dto;
    }
    @Override
    public String toString() {
        return "Office [officeCode=" + officeCode + ", city=" + city + ", country=" + country + ", region=" + region
                + ", postalCode=" + postalCode + ", phone=" + phone + ", address1=" + address1 + ", address2="
                + address2 + "]";
    }

}