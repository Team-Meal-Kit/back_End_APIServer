package com.teammealkit.mealkit.cart.controller;

import com.teammealkit.mealkit.cart.service.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/products")
@RequiredArgsConstructor
@Lazy
public class CartController {
    private final CartService cartService;
}
