package com.example.EcommerceSpring.repository;

import com.example.EcommerceSpring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("SELECT p from Product as p where p.price > :minPrice")
    List<Product> findExpensiveProducts(@Param("minPrice") int minPrice);

    @Query(value = "SELECT * FROM product WHERE MATCH(brand, color, model) AGAINST (:searchText)",nativeQuery = true)
    Optional<List<Product>> searchFullText(@Param("searchText") String searchText);
}