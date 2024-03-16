package com.leprechauns.main.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leprechauns.main.Entity.Employee;
import com.leprechauns.main.Entity.DTO.EmployeeDTO;
import com.leprechauns.main.Repository.EmployeeRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @PersistenceContext
    private EntityManager entityManager;

    private EmployeeDTO convertToObject(Object[] objects, Map<String, Integer> propertyIndices) {
        if (objects == null || objects.length < propertyIndices.size()) {
            throw new IllegalArgumentException("The array of objects is null or doesn't have enough elements");
        }
        EmployeeDTO dto = new EmployeeDTO();
        propertyIndices.forEach((propertyName, index) -> {
                    switch (propertyName) {
                        case "employeeId":
                            dto.setEmployeeId((Integer) objects[index]);
                            break;
                        case "employeeName":
                            dto.setEmployeeName((String) objects[index]);
                            break;
                        case "lastName1":
                            dto.setLastName1((String) objects[index]);
                            break;
                        case "lastName2":
                            dto.setLastName2((String) objects[index]);
                            break;
                        case "extension":
                            dto.setExtension((String) objects[index]);
                            break;
                        case "email":
                            dto.setEmail((String) objects[index]);
                            break;
                        case "rol":
                            dto.setRol((String) objects[index]);
                            break;
                        case "office":
                            dto.setOffice((String) objects[index]);
                            break;
                        case "bossCode":
                            dto.setBossCode((Integer) objects[index]);
                            break;
                    }
        });
        return dto;
    }

    public List<EmployeeDTO> getOfficeDTOListFromObjectArray(List<Object[]> objectList, Map<String, Integer> propertyIndices) {
        return objectList.stream()
                .map(objects -> convertToObject(objects, propertyIndices))
                .collect(Collectors.toList());
    }

    // Queries

    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(Employee::toDTO)
                .toList();
    }

    public List<EmployeeDTO> findEmployeeWithBoss7(){
        List<Object[]> objectList = employeeRepository.findEmployeeWithBoss7();
        Map<String, Integer> propertyIndices = Map.of("employeeName", 0, "lastName1", 1, "lastName2", 2, "email", 3);
        return getOfficeDTOListFromObjectArray(objectList, propertyIndices);
    } 

    public List<EmployeeDTO> findDatasOfBoss(){
        List<Object[]> objectList = employeeRepository.findDatasOfBoss();
        Map<String, Integer> propertyIndices = Map.of("rol", 0,"employeeName", 1, "lastName1", 2, "lastName2", 3, "email", 4);
        return getOfficeDTOListFromObjectArray(objectList, propertyIndices);
    } 

    public List<EmployeeDTO> findEmployeeIsntSalesArea(){
        List<Object[]> objectList = employeeRepository.findEmployeeIsntSalesArea();
        Map<String, Integer> propertyIndices = Map.of("employeeName", 0, "lastName1", 1, "lastName2", 2, "rol", 3);
        return getOfficeDTOListFromObjectArray(objectList, propertyIndices);
    } 

     public List<Map<String, Object>> findEmployeesWithBosses() {
        return employeeRepository.findEmployeesWithBosses();     
    }

    public List<Map<String, Object>> findEmployeeWithBossAndBossOfTheBoss(){
        return employeeRepository.findEmployeeWithBossAndBossOfTheBoss();
    }

    public List<EmployeeDTO> findEmployeeWithoutOffice(){
        List<Object[]> objectList = employeeRepository.findEmployeeWithoutOffice();
        Map<String, Integer> propertyIndices = Map.of("office", 0, "employeeName", 1);
        return getOfficeDTOListFromObjectArray(objectList, propertyIndices);
    }

    public List<String> findEmployeeWithoutCustomer(){
        return employeeRepository.findEmployeeWithoutCustomer();
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> findEmployeeWithoutCustomerWithDatasOffice() {
        return entityManager.createQuery("SELECT DISTINCT e.employeeName, o " +
                                          "FROM Employee e " +
                                          "LEFT JOIN Customer c ON e.employeeId = c.sales.employeeId " +
                                          "LEFT JOIN Office o ON e.office.officeCode = o.officeCode " +
                                          "WHERE c.sales.employeeId IS NULL")
                           .getResultList();
    }

    public List<EmployeeDTO> findEmployeeWithoutOfficeAndCustomer(){
        List<Object[]> objectList = employeeRepository.findEmployeeWithoutOfficeAndCustomer();
        Map<String, Integer> propertyIndices = Map.of("office", 0, "employeeName", 1);
        return getOfficeDTOListFromObjectArray(objectList, propertyIndices);
    }

    public List<Map<String, Object>> findEmployeeWithoutCustomersAndBoss() {
        List<Object[]> resultList = employeeRepository.findEmployeeWithoutCustomersAndBoss();
        List<Map<String, Object>> result = new ArrayList<>();

        for (Object[] row : resultList) {
            Employee employee = (Employee) row[0];
            String bossName = (String) row[1];

            Map<String, Object> rowData = new LinkedHashMap<>();
            rowData.put("employeeId", employee.getEmployeeId());
            rowData.put("employeeName", employee.getEmployeeName());
            rowData.put("lastName1", employee.getLastName1());
            rowData.put("lastName2", employee.getLastName2());
            rowData.put("extension", employee.getExtension());
            rowData.put("email", employee.getEmail());
            rowData.put("rol", employee.getRol());
            rowData.put("boss_name", bossName); 
            
            result.add(rowData);
        }
        return result;
    }

    public List<Integer> findEmployeeNumber(){
        return employeeRepository.findEmployeeNumber();
    }

    public List<Map<String, Object>> findSalesEmployeeAndCustomerNumber() {
        List<Object[]> resultList = employeeRepository.findSalesEmployeeAndCustomerNumber();
        List<Map<String, Object>> result = new ArrayList<>();

        for (Object[] row : resultList) {
            String employeeName = (String) row[0];
            Long customerCount = (Long) row[1];

            Map<String, Object> rowData = new LinkedHashMap<>(); 
            rowData.put("employeeName_rep_ventas", employeeName);
            rowData.put("number_customers", customerCount);

            result.add(rowData);
        }
        return result;
    }
}