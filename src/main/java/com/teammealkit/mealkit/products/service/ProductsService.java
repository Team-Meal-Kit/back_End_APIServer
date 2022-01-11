package com.teammealkit.mealkit.products.service;

import com.teammealkit.mealkit.products.domain.Products;
import com.teammealkit.mealkit.products.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Lazy
public class ProductsService {

    private final ProductsRepository productsRepository;

    public Optional<Products> productInfo(Long id){
       return productsRepository.findAllById(id);
    }

}
