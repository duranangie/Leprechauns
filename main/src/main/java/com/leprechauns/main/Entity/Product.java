package com.leprechauns.main.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "producto")
public class Product {
    @Id
    @Column(name = "codigo_producto")
    private String productId;

    @Column(name = "nombre", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gama", nullable = false)
    private GamaProduct gamaProduct;

    @Column(name = "dimensiones")
    private String dimensions;

    @Column(name = "proveedor")
    private String supplier;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "cantidad_en_stock", nullable = false)
    private int amountInStock;

    @Column(name = "precio_venta", nullable = false)
    private double salePrice;

    @Column(name = "precio_proveedor")
    private double supplierPrice;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productCode) {
        this.productId = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GamaProduct getGamaProduct() {
        return gamaProduct;
    }

    public void setGamaProduct(GamaProduct gamaProduct) {
        this.gamaProduct = gamaProduct;
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

    @Override
    public String toString() {
        return "Product{" +
                "productCode='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", gamaProduct=" + gamaProduct +
                ", dimensions='" + dimensions + '\'' +
                ", supplier='" + supplier + '\'' +
                ", description='" + description + '\'' +
                ", amountInStock=" + amountInStock +
                ", salePrice=" + salePrice +
                ", supplierPrice=" + supplierPrice +
                '}';
    }

}
