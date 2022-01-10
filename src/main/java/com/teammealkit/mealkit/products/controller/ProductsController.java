package com.teammealkit.mealkit.products.controller;

import com.teammealkit.mealkit.MealkitApplication;
import com.teammealkit.mealkit.products.service.ProductsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "products")
@RequiredArgsConstructor
@Lazy
public class ProductsController {
    private final ProductsService productsService;

    @GetMapping("/{id}")
    public Map <String, Integer> Pro
}
