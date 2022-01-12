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

    /* products/"id" id값 받아서 id를 기준으로 해당 id의 모든 데이터를 프론트로 넘겨줌
    * ex) 현재 id=1 만 db에 존재함
    * -> localhost:8080/products/1 정상 작동
    * -> localhost:8080/products/2 데이터 값이 없어서 null 출력
    * -> localhost:8080/products/test id가 아닌 String으로 파라매터가 들어갔기 때문에 파라매터 오류로 400 오류
    * */
    @GetMapping("/{id}")
    public Optional<Products> Product(@PathVariable(value = "id") Long id){
        return productsService.productInfo(id);
    }
}
