package com.leprechauns.main.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.leprechauns.main.Entity.GamaProduct;

@Repository
public interface GamaProductRepository extends JpaRepository<GamaProduct, String> {

}