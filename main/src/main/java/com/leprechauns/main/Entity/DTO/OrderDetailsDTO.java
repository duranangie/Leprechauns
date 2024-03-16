package com.leprechauns.main.Entity.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDetailsDTO {
    private Integer orderCode;
    private String productCode;
    private Integer amount;
    private Double unitPrice;
    private Integer numberLine;


    public OrderDetailsDTO() {
    }

    public Integer getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(Integer orderCode) {
        this.orderCode = orderCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getNumberLine() {
        return numberLine;
    }

    public void setNumberLine(Integer numberLine) {
        this.numberLine = numberLine;
    }

}