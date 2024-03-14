package com.leprechauns.main.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leprechauns.main.Entity.ProductRange;
import com.leprechauns.main.Repository.ProductRangeRepository;

import java.util.List;
@Service
public class ProductRangeService {

    @Autowired
    public ProductRangeRepository productRangeRepository;

    public List<ProductRange> getAllProductsRange(){
        return productRangeRepository.findAll();
    }
}