package com.leprechauns.main.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.leprechauns.main.Entity.Office;

@Repository
public interface OfficeRepository extends JpaRepository<Office, String> {

    @Query("SELECT o.officeCode, o.city FROM Office o")
    List<Object[]> findOfficeCodeAndCity();

    @Query("SELECT o.phone, o.city FROM Office o WHERE o.country='España'")
    List<Object[]> findOfficeSpain();

    @Query("SELECT CONCAT(o.address1, o.address2) AS office_address " 
        + "FROM Office o JOIN Employee e ON o.officeCode = e.office.officeCode " 
        + "JOIN Customer c ON c.sales.employeeId = e.employeeId "
        + "WHERE c.city = 'Fuenlabrada'")
    List<Object[]> findOfficeAddress(); 

    @Query("SELECT DISTINCT o.officeCode "
            + "FROM Office o "
            + "LEFT JOIN Employee e ON o.officeCode = e.office.officeCode "
            + "LEFT JOIN Customer c ON e.employeeId = c.sales.employeeId "
            + "LEFT JOIN Order p ON c.customerId = p.customer.customerId "
            + "LEFT JOIN OrderDetails d ON p.orderCode = d.order.orderCode "
            + "LEFT JOIN Product pr ON d.product.productId = pr.productId "
            + "WHERE pr.rangeProduct.range = 'Frutales' "
            + "AND c.sales.employeeId IS NOT NULL "
            + "AND e.employeeId IS NOT NULL "
            + "AND c.customerId IS NOT NULL "
            + "AND p.orderCode IS NOT NULL "
            + "AND d.order.orderCode IS NOT NULL "
            + "AND pr.productId IS NOT NULL AND o.officeCode IS NOT NULL")
    List<Object[]> findOfficeEmployeeDontWorkEachProductFrutal();
}