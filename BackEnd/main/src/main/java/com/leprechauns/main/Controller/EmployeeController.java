package com.leprechauns.main.Controller;

import java.util.List;
import java.util.Map;

import javax.naming.NameNotFoundException;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leprechauns.main.Entity.DTO.EmployeeDTO;
import com.leprechauns.main.Service.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin("*")
@PreAuthorize("hasRole('ADMIN')")
@SecurityRequirement(name = "bearerAuth")
public class EmployeeController  {
    
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    
    @GetMapping("/employee-boss-7/{employeeId}")
    public ResponseEntity<List<EmployeeDTO>> getEmployeeWithBoss7(@PathVariable int employeeId){
        List<EmployeeDTO> employeeBoss = employeeService.findEmployeeWithBoss7(employeeId);
        return ResponseEntity.ok(employeeBoss);
    }

    @GetMapping("/data-boss")
    public ResponseEntity<List<EmployeeDTO>> getDatasOfBoss(){
        List<EmployeeDTO> employeeBoss = employeeService.findDatasOfBoss();
        return ResponseEntity.ok(employeeBoss);
    }

    @GetMapping("/employee-without-sales-area/{sales}")
    public ResponseEntity<List<EmployeeDTO>> getEmployeeIsntSalesArea(@PathVariable String sales){
        List<EmployeeDTO> employeeBoss = employeeService.findEmployeeIsntSalesArea(sales);
        return ResponseEntity.ok(employeeBoss);
    }

    @GetMapping("/employee-with-bosses")
    public List<Map<String, Object>> getEmployeesWithBosses(){
        return employeeService.findEmployeesWithBosses();
    }

    @GetMapping("/employee-with-boss-and-boss-with-boss")
    public List<Map<String, Object>> getEmployeeWithBossAndBossOfTheBoss(){
        return employeeService.findEmployeeWithBossAndBossOfTheBoss();
    }

    @GetMapping("/employee-without-office")
    public ResponseEntity<List<EmployeeDTO>> getEmployeeWithoutOffice(){
        List<EmployeeDTO> employeeOffice = employeeService.findEmployeeWithoutOffice();
        return ResponseEntity.ok(employeeOffice);
    }

    @GetMapping("/employee-without-customer")
    public List<String> getEmployeeWithoutCustomer() throws NameNotFoundException{
        try {
            return employeeService.findEmployeeWithoutCustomer();
        } catch (Exception e) {
           throw new NameNotFoundException("ENDPOINT NOT FOUND");
        }
    }

    @GetMapping("/employee-without-customer-with-office")
    public List<Object[]> getEmployeeWithoutCustomerWithDatasOffice() {
        return employeeService.findEmployeeWithoutCustomerWithDatasOffice();
    }

    @GetMapping("/employee-without-office-and-customer")
    public ResponseEntity<List<EmployeeDTO>> getEmployeeWithoutOfficeAndCustomer(){
        List<EmployeeDTO> employeeWithoutOfficeCustomer = employeeService.findEmployeeWithoutOfficeAndCustomer();
        return ResponseEntity.ok(employeeWithoutOfficeCustomer);
    }

    @GetMapping("/employee-without-customer-and-boss")
    public ResponseEntity<List<Map<String, Object>>> getEmployeesWithoutCustomersAndBoss() {
        List<Map<String, Object>> employeesWithoutCustomersAndBoss = employeeService.findEmployeeWithoutCustomersAndBoss();
        return ResponseEntity.ok(employeesWithoutCustomersAndBoss);
    }

    @GetMapping("/employee-total-number")
    public List<Integer> getEmployeeNumber(){
        return employeeService.findEmployeeNumber();
    }

    @GetMapping("/sales-employee-and-customer-count")
    public ResponseEntity<List<Map<String, Object>>> getSalesEmployeeAndCustomerNumber() {
        List<Map<String, Object>> salesEmployeeAndCustomerNumber = employeeService.findSalesEmployeeAndCustomerNumber();
        return ResponseEntity.ok(salesEmployeeAndCustomerNumber);
    }
}
