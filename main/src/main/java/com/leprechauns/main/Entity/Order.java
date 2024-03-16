package com.leprechauns.main.Entity;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.leprechauns.main.Entity.DTO.OrderDTO;
import com.leprechauns.main.Entity.oderdetails.OrderDetails;

import jakarta.persistence.*;

@Entity
@Table(name = "pedido")
public class Order {

    @Id
    @Column(name = "codigo_pedido")
    private Integer orderCode;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_pedido", nullable = false)
    private Date orderDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_esperada", nullable = false)
    private Date expectedDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_entrega")
    private Date deliverDate;

    @Column(name = "estado", nullable = false)
    private String status;

    @Column(name = "comentarios")
    private String comments;

    public Integer getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(Integer orderCode) {
        this.orderCode = orderCode;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(Date expectedDate) {
        this.expectedDate = expectedDate;
    }

    public Date getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(Date deliverDate) {
        this.deliverDate = deliverDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    // Relations
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo_cliente", nullable = false)
    private Customer customer;

    @JsonIgnore
    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private List<OrderDetails> order;

    /* DTO */
    public OrderDTO toDTO() {
        OrderDTO dto = new OrderDTO();
        dto.setOrderCode(this.orderCode);
        dto.setOrderDate(this.orderDate);
        dto.setExpectedDate(this.expectedDate);
        dto.setDeliverDate(this.deliverDate != null ? this.deliverDate : null);
        dto.setStatus(this.status);
        dto.setComments(this.comments != null ? this.comments : null);
        dto.setCustomerId(this.getCustomer().getCustomerId());
        return dto;
    }

    @Override
    public String toString() {
        return "Order [orderCode=" + orderCode + ", orderDate=" + orderDate + ", expectedDate=" + expectedDate
                + ", deliverDate=" + deliverDate + ", status=" + status + ", comments=" + comments + ", customer="
                + customer + "]";
    }

}
