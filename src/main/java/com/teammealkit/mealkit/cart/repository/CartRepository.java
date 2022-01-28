package com.teammealkit.mealkit.cart.repository;

import com.teammealkit.mealkit.cart.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByClient_Idx(Long idx);
}

