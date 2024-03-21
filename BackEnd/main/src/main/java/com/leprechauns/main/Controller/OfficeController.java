package com.leprechauns.main.Controller;

import java.util.List;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leprechauns.main.Entity.DTO.OfficeDTO;
import com.leprechauns.main.Service.OfficeService;

@RestController
@RequestMapping("/offices")
@CrossOrigin("*")
@PreAuthorize("hasRole('ADMIN')")
@SecurityRequirement(name = "bearerAuth")
public class OfficeController {
    
    private final OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @GetMapping
    public List<OfficeDTO> getAllOffice(){
        return officeService.getAllOffices();
    }
    
    @GetMapping("/office-code-and-city")
    public ResponseEntity<List<OfficeDTO>> getOfficesByCityAndPhone() {
        List<OfficeDTO> officeCodeAndCity = officeService.findOfficeCodeAndCity();
        return ResponseEntity.ok(officeCodeAndCity);
    }

    @GetMapping("/office-spain/{country}")
    public ResponseEntity<List<OfficeDTO>> getOfficesInSpain(@PathVariable String country) {
        List<OfficeDTO> officesInSpain = officeService.findOfficesSpain(country);
        return ResponseEntity.ok(officesInSpain);
    }

    @GetMapping("/office-address-Fuenlabrada/{city}")
    public List<Object[]> getOfficeAddress(@PathVariable String city){
        return officeService.findOfficeAddress(city);
    }

    @GetMapping("/office-employee-range-Frutales/{gamma}")
    public ResponseEntity<List<OfficeDTO>> getOfficeEmployeeDontWorkEachProductFrutal(@PathVariable String gamma){
        List<OfficeDTO> officeEmployeeDontWorkEachProductFrutal = officeService.findOfficeDontWorkEmployeeRangeFrutales(gamma);
        return ResponseEntity.ok(officeEmployeeDontWorkEachProductFrutal);
    }
}
