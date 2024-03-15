package com.leprechauns.main.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leprechauns.main.Entity.DTO.ProductDTO;
import com.leprechauns.main.Service.ProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin("*")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public List<ProductDTO> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/productstock")
    public List<String> findProductStock() {
        return productService.findProductStock();
    }



    @GetMapping("/productsName")
    public List<String> findNameProduct() {
        return productService.findNameProduct();
    }


    @GetMapping("/productsdescription")
    public List<String> findDescriptionProduct() {
        return productService.findDescriptionProduct();
    }

    @GetMapping("/priceproduct")
    public List<Double[]> findPrice() {
        return productService.findPrice();
    }



    

}