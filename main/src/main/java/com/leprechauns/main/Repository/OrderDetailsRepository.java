package com.leprechauns.main.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.leprechauns.main.Entity.oderdetails.OrderDetailId;
import com.leprechauns.main.Entity.oderdetails.OrderDetails;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, OrderDetailId> {

    @Query("SELECT order.orderCode, COUNT(DISTINCT product.productId) AS number_different_products FROM OrderDetails GROUP BY order.orderCode")
    List<Object[]> findNumberProduct();

//     @Query("SELECT dp.order.orderCode, SUM(dp.amount) AS total_quantity_products "
//             + "FROM OrderDetails dp "
//             + "JOIN Order p ON dp.order.orderCode = p.orderCode "
//             + "GROUP BY dp.order.orderCode "
//             + "ORDER BY dp.order.orderCode ASC")
//     List<Object[]> findTotalProductEachProduct();

//     @Query("SELECT dp.product.productId, p.name AS nombre_producto, SUM(dp.amount) AS total_units_sold "
//             + "FROM OrderDetails dp "
//             + "JOIN Product p ON dp.product.productId = p.productId "
//             + "GROUP BY dp.product.productId, p.name "
//             + "ORDER BY total_units_sold DESC "
//             + "LIMIT 20")
//     List<Object[]> find20ProductTotalUnits();

//     @Query("SELECT SUM(dp.amount * p.salePrice) AS tax_base, SUM(dp.amount * p.salePrice) * 0.21 AS VAT, SUM(dp.amount * p.salePrice) * 1.21 AS total_charged "
//             + "FROM OrderDetails dp "
//             + "JOIN Product p ON dp.product.productId = p.productId")
//     List<Object[]> findVATAndInvoice();

//     @Query("SELECT dp.product.productId, SUM(dp.amount * p.salePrice) AS tax_base, SUM(dp.amount * p.salePrice) * 0.21 AS VAT, SUM(dp.amount * p.salePrice) * 1.21 AS total_charged "
//             + "FROM OrderDetails dp "
//             + "JOIN Product p ON dp.product.productId = p.productId "
//             + "GROUP BY dp.product.productId")
//     List<Object[]> findVATAndInvoiceGroupByProductCode();
            
//     @Query("SELECT dp.product.productId, SUM(dp.amount * p.salePrice) AS tax_base, SUM(dp.amount * p.salePrice) * 0.21 AS VAT, SUM(dp.amount * p.salePrice) * 1.21 AS total_charged "
//             + "FROM OrderDetails dp "
//             + "JOIN Product p ON dp.product.productId = p.productId "
//             + "WHERE dp.product.productId LIKE 'OR%' "
//             + "GROUP BY dp.product.productId")
//     List<Object[]> findVATAndInvoiceGroupByProductCodeAndOr();
    
//     @Query("SELECT p.name AS product_name, SUM(dp.amount) AS sold_units, SUM(dp.amount * p.salePrice) AS total_charged, SUM(dp.amount * p.salePrice) * 1.21 AS total_invoiced_vat"
//             + "FROM OrderDetails dp "
//             + "JOIN Product p ON dp.product.productId = p.productId "
//             + "GROUP BY p.name "
//             + "HAVING SUM(dp.amount * p.salePrice) > 3000")
//     List<Object[]> findInvoiceMore3000();

}