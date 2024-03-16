package com.leprechauns.main.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.leprechauns.main.Entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findByCountryLikeIgnoreCase(String country);

    @Query("SELECT c FROM Customer c "
            + "WHERE c.city = 'Madrid' "
            + "AND (c.sales.employeeId = 11 OR c.sales.employeeId = 30)")
    List<Customer> findCustomersMadrid();

    @Query("SELECT c.customerName FROM Customer c WHERE c.country = 'Spain'")
    List<Customer> findNameSpain();

    @Query("SELECT DISTINCT c.customerId, c.customerName, CONCAT(e.employeeName, ' ', e.lastName1, ' ', e.lastName2) "
            + "FROM Customer c "
            + "JOIN c.sales e")
    List<Object[]> clientsSalesRepresentatives();

    @Query("SELECT DISTINCT c.customerId, c.customerName, CONCAT(e.employeeName, ' ', e.lastName1, ' ', e.lastName2) " +
            "FROM Customer c " +
            "JOIN c.sales e " +
            "LEFT JOIN c.payments p " +
            "WHERE p IS NULL")
    List<Object[]> clientsWithoutPaymentsAndRepresentatives();

    @Query("SELECT DISTINCT c.customerId, c.customerName, CONCAT(e.employeeName, ' ', e.lastName1, ' ', e.lastName2), o.city "
            +
            "FROM Customer c " +
            "JOIN c.sales e " +
            "JOIN e.office o " +
            "LEFT JOIN c.payments p ON c = p.customer " +
            "WHERE p.customer IS NULL")
    List<Object[]> getCityCustomer();

    @Query("SELECT DISTINCT c.customerId, c.customerName, CONCAT(e.employeeName, ' ', e.lastName1, ' ', e.lastName2), o.city "
            +
            "FROM Customer c " +
            "JOIN c.sales e " +
            "JOIN e.office o " +
            "JOIN c.payments")
    List<Object[]> clientsWithPaymentsOfficeCity();

    @Query("SELECT c.customerName FROM Customer c " +
            "JOIN c.orders o " +
            "WHERE o.deliverDate > o.expectedDate " +
            "GROUP BY c.customerName")
    List<String> clientsWithLateDeliveries();

    @Query("SELECT DISTINCT c.customerName, g.range " +
            "FROM OrderDetails od " +
            "JOIN od.order o " +
            "JOIN o.customer c " +
            "JOIN od.product pr " +
            "JOIN pr.rangeProduct g " +
            "GROUP BY c.customerName, g.range")
    List<Object[]> listProductRangesByCustomer();

    @Query("SELECT DISTINCT c FROM Customer c " +
            "LEFT JOIN c.payments p " +
            "WHERE p IS NULL")
    List<Customer> clientsWithoutPayments();

    @Query("SELECT DISTINCT c FROM Customer c " +
            "LEFT JOIN c.orders o " +
            "WHERE o IS NULL")
    List<Customer> clientsWithoutOrders();

    @Query("SELECT c FROM Customer c " +
            "LEFT JOIN c.payments p " +
            "LEFT JOIN c.orders o " +
            "WHERE p IS NULL OR o IS NULL")
    List<Customer> clientsWithoutPaymentsAndOrders();

    @Query("SELECT c FROM Customer c " +
            "JOIN c.orders " +
            "LEFT JOIN c.payments p " +
            "WHERE p IS NULL")
    List<Customer> clientsWithOrdersButNoPayments();

    @Query("SELECT c.country, COUNT(*) " +
            "FROM Customer c " +
            "GROUP BY c.country")
    List<Object[]> clientsCountByCountry();

    @Query("SELECT COUNT(*) FROM Customer")
    int totalClients();

    @Query("SELECT COUNT(*) FROM Customer c WHERE c.city = ?1")
    int clientsCountInCity(String city);

    @Query("SELECT c.city, COUNT(*) FROM Customer c " +
            "WHERE c.city LIKE 'M%' " +
            "GROUP BY c.city")
    List<Object[]> clientsCountInCitiesStartingWithM();

    @Query("SELECT COUNT(*) FROM Customer c " +
            "WHERE c.sales IS NULL")
    int clientsWithoutSales();

    @Query("SELECT " +
            "c.customerId, c.customerName, CONCAT(c.contactName, ' ', c.contactLastName), " +
            "MIN(p.payDay), MAX(p.payDay) " +
            "FROM Customer c " +
            "JOIN c.payments p " +
            "GROUP BY c.customerId")
    List<Object[]> firstLastPaymentDateByClient();
}
