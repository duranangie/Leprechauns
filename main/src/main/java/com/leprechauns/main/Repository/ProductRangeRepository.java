package com.leprechauns.main.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.leprechauns.main.Entity.ProductRange;

@Repository
public interface ProductRangeRepository extends JpaRepository<ProductRange, String> {

}