package com.leprechauns.main.Repository;

import java.util.List;

import org.antlr.v4.runtime.atn.SemanticContext.AND;
import org.antlr.v4.runtime.atn.SemanticContext.OR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.leprechauns.main.Entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {


  List<Customer> findByCountryLikeIgnoreCase(String country);

    @Query("SELECT DISTINCT p.customer.customerId "
            + "FROM Payment p "
            + "WHERE YEAR(p.payDay) = 2008 "
            + "AND p.customer.customerId IS NOT NULL")
    List<Integer> findCustomerPayIn2008();

    // @Query("SELECT c FROM Customer c "
    //         + "WHERE c.city = 'Madrid' "
    //         + "AND (c.repSales.employeeCode = 11 OR c.repSales.employeeCode = 30)")
    // List<Customer> findCustomersMadrid();



}