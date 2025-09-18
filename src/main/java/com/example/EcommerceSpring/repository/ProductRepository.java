package com.example.EcommerceSpring.repository;

import com.example.EcommerceSpring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
