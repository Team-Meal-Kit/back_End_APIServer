package com.teammealkit.mealkit.products.repository;

import com.teammealkit.mealkit.products.domain.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductsRepository extends JpaRepository<Products, Long> {
    Optional <Products> findAllById(Long id);
}
