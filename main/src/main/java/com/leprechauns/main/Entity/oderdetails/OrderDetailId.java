package com.leprechauns.main.Entity.oderdetails;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.persistence.Embeddable;

@Embeddable
public class OrderDetailId implements Serializable {
    
    @Column(name = "codigo_pedido")
    private Integer orderCode;

    @Column(name = "codigo_producto")
    private String productCode;

    public int getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(int orderCode) {
        this.orderCode = orderCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
}