package com.leprechauns.main.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leprechauns.main.Entity.DTO.OfficeDTO;
import com.leprechauns.main.Service.OfficeService;

@RestController
@RequestMapping("/offices")
@CrossOrigin("*")
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

    @GetMapping("/office-spain")
    public ResponseEntity<List<OfficeDTO>> getOfficesInSpain() {
        List<OfficeDTO> officesInSpain = officeService.findOfficesSpain();
        return ResponseEntity.ok(officesInSpain);
    }

    @GetMapping("/office-address-Fuenlabra")
    public List<Object[]> getOfficeAddress(){
        return officeService.findOfficeAddress();
    }

    @GetMapping("/office-employee-range-Frutales")
    public ResponseEntity<List<OfficeDTO>> getOfficeEmployeeDontWorkEachProductFrutal(){
        List<OfficeDTO> officeAddressFuenlabra = officeService.findOfficeDontWorkEmployeeRangeFrutales();
        return ResponseEntity.ok(officeAddressFuenlabra);
    }
}
