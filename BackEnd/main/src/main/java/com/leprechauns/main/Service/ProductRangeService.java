package com.leprechauns.main.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leprechauns.main.Entity.ProductRange;
import com.leprechauns.main.Entity.DTO.ProductRangeDTO;
import com.leprechauns.main.Repository.ProductRangeRepository;

import java.util.List;
@Service
public class ProductRangeService {

    @Autowired
    public ProductRangeRepository productRangeRepository;

    public List<ProductRangeDTO> getAllProductsRange(){
        return productRangeRepository.findAll().stream()
                .map(ProductRange::toDTO)
                .toList();
    }
}