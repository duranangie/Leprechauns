package com.leprechauns.main.Entity;

import java.util.List;

import com.leprechauns.main.Entity.DTO.ProductRangeDTO;

import jakarta.persistence.*;

@Entity
@Table(name = "gama_producto")
public class ProductRange {
    @Id
    @Column(name = "gama", nullable = false)
    private String range;

    @Column(name = "descripcion_texto")
    private String textDescription;

    @Column(name = "descripcion_html")
    private String htmlDescription;

    @Column(name = "imagen")
    private String image;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "rangeProduct", cascade = CascadeType.ALL)
    private List<Product> products;

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public String getHtmlDescription() {
        return htmlDescription;
    }

    public void setHtmlDescription(String htmlDescription) {
        this.htmlDescription = htmlDescription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /* DTO */

    ProductRangeDTO toDTO() {
        ProductRangeDTO dto = new ProductRangeDTO();
        dto.setRange(this.range);
        dto.setTextDescription(this.textDescription != null ? this.textDescription : null);
        dto.setHtmlDescription(this.htmlDescription != null ? this.htmlDescription : null);
        dto.setImage(this.image != null ? this.image : null);
        return dto;
    }

    @Override
    public String toString() {
        return "rangeProduct [range=" + range + ", textDescription=" + textDescription + ", htmlDescription="
                + htmlDescription + ", image=" + image + "]";
    }

}
