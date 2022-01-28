package com.teammealkit.mealkit.cart.controller;

import com.teammealkit.mealkit.cart.domain.Cart;
import com.teammealkit.mealkit.cart.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(path = "/cart")
@RequiredArgsConstructor
@Lazy
public class CartController {
    private final CartService cartService;

    @GetMapping("/{idx}")
    public Optional<Cart> Cart(@PathVariable(value = "idx") Long idx){
        return cartService.getCartList(idx);
    }
}
