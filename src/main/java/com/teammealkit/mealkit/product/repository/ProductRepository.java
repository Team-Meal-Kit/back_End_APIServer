package com.teammealkit.mealkit.product.repository;

import com.teammealkit.mealkit.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional <Product> findAllById(Long id);
}
