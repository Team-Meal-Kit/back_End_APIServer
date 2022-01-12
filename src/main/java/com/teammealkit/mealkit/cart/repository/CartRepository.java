package com.teammealkit.mealkit.cart.repository;

import com.teammealkit.mealkit.cart.domain.Cart;
import com.teammealkit.mealkit.products.domain.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findAllByClientNum(Long id);
}
