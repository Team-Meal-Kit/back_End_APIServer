package com.teammealkit.mealkit.products.controller;

import com.teammealkit.mealkit.products.domain.Products;
import com.teammealkit.mealkit.products.service.ProductsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(path = "/products")
@RequiredArgsConstructor
@Lazy
public class ProductsController {
    private final ProductsService productsService;

    @GetMapping("/{id}")
    public Optional<Products> Product(@PathVariable(value = "id") Long id){
        return productsService.productInfo(id);
    }
}
