package com.leprechauns.main.Repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.leprechauns.main.Entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {

    @Query("SELECT DISTINCT customer.customerId FROM Payment WHERE EXTRACT(YEAR FROM payDay) = 2008")
    List<Integer> findCustomerPayment2008();

    @Query("SELECT p FROM Payment p WHERE EXTRACT(YEAR FROM payDay) = 2008 AND paymentForm = 'PayPal' ORDER BY payDay DESC")
    List<Payment> findPayments2008PayPal();

    @Query("SELECT DISTINCT paymentForm FROM Payment")
    List<String> findPaymentForm();

    @Query("SELECT DISTINCT c.customerName AS paying_customer, CONCAT(e.employeeName, ' ', e.lastName1, ' ', e.lastName2) AS sales_employee "  
            + "FROM Payment p "
            + "JOIN Customer c ON p.customer.customerId = c.customerId " 
            + "JOIN Employee e ON c.sales.employeeId = e.employeeId")
    List<Map<String, Object>> findPayingCustomerSalesEmployee();

    @Query("SELECT DISTINCT c.customerName AS paying_customer, CONCAT(e.employeeName, ' ', e.lastName1, ' ', e.lastName2) AS sales_employee, o.city AS city_office " 
            + "FROM Payment p "
            + "JOIN Customer c ON p.customer.customerId = c.customerId " 
            + "JOIN Employee e ON c.sales.employeeId = e.employeeId "
            + "JOIN Office o ON e.office.officeCode = o.officeCode")
    List<Map<String, Object>> findPayingCustomerSalesEmployeeWithOffice();

    @Query("SELECT ROUND(AVG(total), 2) AS average_payment FROM Payment WHERE EXTRACT(YEAR FROM payDay) = 2009")
    List<Double> findAveragePayment();

    @Query("SELECT EXTRACT(YEAR FROM payDay) AS year, SUM(total) AS total_payments FROM Payment GROUP BY EXTRACT(YEAR FROM payDay)")
    List<Map<String, Object>> findTotalPaymentPerYear();
}