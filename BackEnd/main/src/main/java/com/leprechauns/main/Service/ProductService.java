package com.leprechauns.main.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leprechauns.main.Entity.Product;
import com.leprechauns.main.Entity.DTO.ProductDTO;
import com.leprechauns.main.Repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    public ProductRepository productRepository;

    public List<ProductDTO> getAllProducts(){
        return productRepository.findAll().stream()
                .map(Product::toDTO)
                .toList();
    }

    public List<String> findProductStock() {
        return productRepository.findProductStock();
    }

    public List<String> findNameProduct() {
        return productRepository.findNameProduct();
    }

    public List<String> findDescriptionProduct() {
        return productRepository.findDescriptionProduct();
    }

    public List<Double[]> findPrice() {
        return productRepository.findPrice();
    }
}