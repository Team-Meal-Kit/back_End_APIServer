package com.teammealkit.mealkit.cart.service;

import com.teammealkit.mealkit.cart.domain.Cart;
import com.teammealkit.mealkit.cart.repository.CartRepository;
import com.teammealkit.mealkit.products.domain.Products;
import com.teammealkit.mealkit.products.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Lazy
public class CartService {

        private final CartRepository cartRepository;

        public Optional<Cart> cartInfo(Long id){
            return cartRepository.findAllByClientNum(id);
        }
}