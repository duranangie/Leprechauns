package com.leprechauns.main.Entity.DTO;

public class ProductDTO {
    private String productId;
    private String name;
    private String rangeProduct;
    private String dimensions;
    private String supplier;
    private String description;
    private int amountInStock;
    private double salePrice;
    private double supplierPrice;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRangeProduct() {
        return rangeProduct;
    }

    public void setRangeProduct(String rangeProduct) {
        this.rangeProduct = rangeProduct;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmountInStock() {
        return amountInStock;
    }

    public void setAmountInStock(int amountInStock) {
        this.amountInStock = amountInStock;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public double getSupplierPrice() {
        return supplierPrice;
    }

    public void setSupplierPrice(double supplierPrice) {
        this.supplierPrice = supplierPrice;
    }

}
