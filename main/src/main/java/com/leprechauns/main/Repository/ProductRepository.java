package com.leprechauns.main.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.leprechauns.main.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    @Query("SELECT p.productId "
            + "FROM Product p "
            + "WHERE p.rangeProduct.range = 'Ornamentales' AND p.amountInStock > 100 "
            + "ORDER BY p.salePrice DESC")
    List<String> findProductStock();

    @Query("SELECT pr.name AS name_product "
            + "FROM Product pr "
            + "LEFT JOIN OrderDetails d ON pr.productId = d.product.productId "
            + "WHERE d.product.productId IS NULL")
    List<String> findNameProduct();

    @Query("SELECT pr.name AS nameProduct, pr.description, g.image " +
            "FROM Product pr " +
            "LEFT JOIN OrderDetails d ON pr.productId = d.product.productId " +
            "LEFT JOIN ProductRange g ON pr.rangeProduct.range = g.range " +
            "WHERE d.product.productId IS NULL")
    List<String> findDescriptionProduct();

    @Query("SELECT MAX(p.salePrice) AS maxSalePrice, MIN(p.salePrice) AS minSalePrice FROM Product p")
    List<Double[]> findPrice();

}