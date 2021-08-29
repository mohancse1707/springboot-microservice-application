package com.mohan.ms.repository;

import com.mohan.ms.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findOneByProductId(String productId);
}
