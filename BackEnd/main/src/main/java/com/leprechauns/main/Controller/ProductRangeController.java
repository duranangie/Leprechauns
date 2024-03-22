package com.leprechauns.main.Controller;

import java.util.List;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leprechauns.main.Entity.DTO.ProductRangeDTO;
import com.leprechauns.main.Service.ProductRangeService;

@RestController
@RequestMapping("/ranges")
@CrossOrigin("*")
@PreAuthorize("hasRole('ADMIN')")
@SecurityRequirement(name = "bearerAuth")
public class ProductRangeController {
    
    private final ProductRangeService productRangeService;

    @Autowired
    public ProductRangeController(ProductRangeService productRangeService) {
        this.productRangeService = productRangeService;
    }

    @GetMapping
    public List<ProductRangeDTO> getAllProductsRange(){
        return productRangeService.getAllProductsRange();
    }
}
