package com.leprechauns.main.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    

}
