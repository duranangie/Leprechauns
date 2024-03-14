package com.leprechauns.main.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leprechauns.main.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

}