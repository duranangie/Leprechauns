package com.leprechauns.main.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="empleado")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_empleado")
    private Long employeeId;
    @Column(name="nombre")
    private String employeeName;
    @Column(name="apellido1")
    private String lastName1;
    @Column(name="apellido2")
    private String lastName2;
    @Column(name="extension")
    private String extension;
    @Column(name="email")
    private String email;
//    RELATION ONE TO MANY WITH THE TABLE "oficina"
    @Column(name="codigo_oficina")
    @ManyToOne
    @JoinColumn(name = "oficina")
    private String officeCode;
//    RELATION MANY TO ONE WITH THE TABLE ITSELF "empleado"
    @Column(name="codigo_jefe")
    @ManyToOne
    @JoinColumn(name = "empleado")
    private Long bossCode;
    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Employee> employees = new ArrayList<>();
    @Column(name="puesto")
    private String position;
//    RELATION ONE TO MANY WITH THE TABLE "cliente"
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Customer> customers = new ArrayList<>();
}
