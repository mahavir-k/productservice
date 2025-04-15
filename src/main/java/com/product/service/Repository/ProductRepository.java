package com.product.service.Repository;

import com.product.service.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {
    public ProductEntity findByProductName(String productName);
}
