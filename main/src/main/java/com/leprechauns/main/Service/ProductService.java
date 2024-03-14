package com.leprechauns.main.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leprechauns.main.Entity.Product;
import com.leprechauns.main.Repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    public ProductRepository productRepository;

    public List<Product> getAllProducs(){
        return productRepository.findAll();
    }
}