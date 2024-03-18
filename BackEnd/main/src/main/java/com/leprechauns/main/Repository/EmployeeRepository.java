package com.leprechauns.main.Repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.leprechauns.main.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

        @Query("SELECT DISTINCT e.employeeName, e.lastName1, e.lastName2, e.email "
                        + "FROM Employee e "
                        + "JOIN Employee j ON e.bossCode.employeeId = j.bossCode.employeeId "
                        + "WHERE j.bossCode.employeeId = 7")
        List<Object[]> findEmployeeWithBoss7();

        @Query("SELECT rol, employeeName, lastName1, lastName2, email "
                        + "FROM Employee "
                        + "WHERE bossCode.employeeId IS NULL")
        List<Object[]> findDatasOfBoss();

        @Query("SELECT employeeName, lastName1, lastName2, rol "
                        + "FROM Employee "
                        + "WHERE rol != 'Representante Ventas'")
        List<Object[]> findEmployeeIsntSalesArea();

        @Query("SELECT NEW map(e.employeeName AS employee_name, j.employeeName AS boss_name) "
                        + "FROM Employee e "
                        + "LEFT JOIN Employee j ON e.bossCode.employeeId = j.employeeId")
        List<Map<String, Object>> findEmployeesWithBosses();

        @Query("SELECT NEW map(jj.employeeName AS boss_name_of_boss,e.employeeName AS employee_name, j.employeeName AS boss_name) "
                        + "FROM Employee e "
                        + "LEFT JOIN Employee j ON e.bossCode.employeeId  = j.employeeId "
                        + "LEFT JOIN Employee jj ON jj.employeeId = j.bossCode.employeeId")
        List<Map<String, Object>> findEmployeeWithBossAndBossOfTheBoss();

        @Query("SELECT o.officeCode, e.employeeName "
                        + "FROM Employee e "
                        + "RIGHT JOIN Office o ON e.office.officeCode = o.officeCode "
                        + "WHERE e.office.officeCode IS NULL")
        List<Object[]> findEmployeeWithoutOffice();

        @Query("SELECT DISTINCT e.employeeName "
                        + "FROM Employee e "
                        + "LEFT JOIN Customer c ON e.employeeId = c.sales.employeeId "
                        + "WHERE c.sales.employeeId  IS NULL")
        List<String> findEmployeeWithoutCustomer();

        @Query("SELECT DISTINCT e.employeeName, o " +
                        "FROM Employee e " +
                        "LEFT JOIN Customer c ON e.employeeId = c.sales.employeeId " +
                        "LEFT JOIN Office o ON e.office.officeCode = o.officeCode " +
                        "WHERE c.sales.employeeId IS NULL")
        List<Object[]> findEmployeeWithoutCustomerWithDatasOffice();

        @Query("SELECT o.officeCode, e.employeeName "
                        + "FROM Employee e "
                        + "RIGHT JOIN Office o ON e.office.officeCode = o.officeCode "
                        + "LEFT JOIN Customer c ON e.employeeId = c.sales.employeeId "
                        + "WHERE e.office.officeCode IS NULL AND c.sales.employeeId IS NULL")
        List<Object[]> findEmployeeWithoutOfficeAndCustomer();

        @Query("SELECT DISTINCT e, j.employeeName AS boss_name " +
                        "FROM Employee e " +
                        "LEFT JOIN Customer c ON e.employeeId = c.sales.employeeId " +
                        "LEFT JOIN Employee j ON e.bossCode.employeeId = j.employeeId " +
                        "WHERE c.sales.employeeId IS NULL")
        List<Object[]> findEmployeeWithoutCustomersAndBoss();

        @Query("SELECT COUNT(*) AS total_employees FROM Employee")
        List<Integer> findEmployeeNumber();

        @Query("SELECT rp.employeeName AS sales_employee, COUNT(c.customerId) AS number_customers "
                        + "FROM Employee rp "
                        + "LEFT JOIN Customer c ON rp.employeeId = c.sales.employeeId "
                        + "WHERE c.customerId IS NOT NULL "
                        + "GROUP BY rp.employeeName")
        List<Object[]> findSalesEmployeeAndCustomerNumber();
}