package com.leprechauns.main.Entity;

import com.leprechauns.main.Entity.DTO.ProductDTO;

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
    private ProductRange rangeProduct;

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

    public ProductRange getRangeProduct() {
        return rangeProduct;
    }

    public void setRangeProduct(ProductRange rangeProduct) {
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

    /* DTO */

    public ProductDTO toDTO() {
        ProductDTO dto = new ProductDTO();
        dto.setProductId(this.productId);
        dto.setName(this.name);
        dto.setRangeProduct(this.getRangeProduct().getRange());
        dto.setDimensions(this.dimensions);
        dto.setSupplier(this.supplier);
        dto.setDescription(this.description);
        dto.setAmountInStock(this.amountInStock);
        dto.setSalePrice(this.salePrice);
        dto.setSupplierPrice(this.supplierPrice);

        return dto;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCode='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", rangeProduct=" + rangeProduct +
                ", dimensions='" + dimensions + '\'' +
                ", supplier='" + supplier + '\'' +
                ", description='" + description + '\'' +
                ", amountInStock=" + amountInStock +
                ", salePrice=" + salePrice +
                ", supplierPrice=" + supplierPrice +
                '}';
    }

}
