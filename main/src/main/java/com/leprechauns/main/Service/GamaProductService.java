package com.leprechauns.main.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leprechauns.main.Entity.GamaProduct;
import com.leprechauns.main.Repository.GamaProductRepository;

import java.util.List;
@Service
public class GamaProductService {

    @Autowired
    public GamaProductRepository gamaProductRepository;

    public List<GamaProduct> getAllGamaProducts(){
        return gamaProductRepository.findAll();
    }
}