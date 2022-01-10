package com.teammealkit.mealkit.products.service;

import com.teammealkit.mealkit.products.domain.Products;
import com.teammealkit.mealkit.products.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Lazy
public class ProductsService {
    private final ProductsRepository productsRepository;

    // SELECT client
    public Products selectClient(Long id) {
        Products client = clientRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Can't find target client"
                ));

        return client;
    }

    //SELECT ALL Clients
    public List<Products> selectClientList() {
        return clientRepository.findAll();
    }
}
