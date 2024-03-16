package com.leprechauns.main.Entity;

import jakarta.persistence.*;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.leprechauns.main.Entity.DTO.EmployeeDTO;

@Entity
@Table(name = "empleado")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "employeeId")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_empleado")
    private Integer employeeId;
    @Column(name = "nombre", nullable = false)
    private String employeeName;
    @Column(name = "apellido1", nullable = false)
    private String lastName1;
    @Column(name = "apellido2")
    private String lastName2;
    @Column(name = "extension", nullable = false)
    private String extension;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "puesto")
    private String rol;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo_oficina")
    private Office office;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo_jefe")
    private Employee bossCode;

    @JsonIgnore
    @OneToMany(mappedBy = "sales", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Customer> customers;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getLastName1() {
        return lastName1;
    }

    public void setLastName1(String lastName1) {
        this.lastName1 = lastName1;
    }

    public String getLastName2() {
        return lastName2;
    }

    public void setLastName2(String lastName2) {
        this.lastName2 = lastName2;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Employee getBossCode() {
        return bossCode;
    }

    public void setBossCode(Employee bossCode) {
        this.bossCode = bossCode;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    /* DTO */

    public EmployeeDTO toDTO() {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setEmployeeId(this.employeeId);
        dto.setEmployeeName(this.employeeName);
        dto.setLastName1(this.lastName1);
        dto.setLastName2(this.lastName2);
        dto.setExtension(this.extension);
        dto.setEmail(this.email);
        dto.setRol(this.rol);
        dto.setOffice(this.office != null ? this.office.getOfficeCode() : null);
        dto.setBossCode(this.bossCode != null ? this.bossCode.getEmployeeId() : null);
        return dto;
    }

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", lastName1=" + lastName1
                + ", lastName2=" + lastName2 + ", extension=" + extension + ", email=" + email + ", rol=" + rol
                + ", office=" + office + ", bossCode=" + bossCode + "]";
    }
}
