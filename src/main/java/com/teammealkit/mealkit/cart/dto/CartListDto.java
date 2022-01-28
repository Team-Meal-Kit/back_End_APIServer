package com.teammealkit.mealkit.cart.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CartListDto {
    private Long cartProductId;
    private String productName;
    private int price;
    private int count;
    private String imgUrl;

    public CartListDto(Long cartProductId, String productName, int price, int count, String imgUrl){
        this.cartProductId = cartProductId;
        this.productName = productName;
        this.price = price;
        this.count = count;
        this.imgUrl = imgUrl;
    }
}
