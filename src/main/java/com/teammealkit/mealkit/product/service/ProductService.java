package com.teammealkit.mealkit.product.service;

import com.teammealkit.mealkit.product.domain.Product;
import com.teammealkit.mealkit.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Lazy
public class ProductService {

    private final ProductRepository productRepository;

    public Optional<Product> productInfo(Long id){
       return productRepository.findAllById(id);
    }

}
