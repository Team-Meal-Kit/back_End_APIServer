package com.teammealkit.mealkit.product.domain;

import com.teammealkit.mealkit.cart.domain.Cart;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name", length = 64, nullable = false)
    private String name;

    @Column(name = "price")
    private Long price;

    @Column(name = "count")
    private Integer count;

    @Column(name = "discount")
    private Integer discount;

    @Column(name = "img_main", length = 256)
    private String imgMain;

    @Column(name = "img_content",length = 256)
    private String imgContent;

    @Column(name = "content",length = 256)
    private String content;

    @Column(name = "view_cnt")
    private Long viewCount;

    @Column(name = "sales_cnt")
    private Long salesCount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "reg_date")
    public Date regDate;

    @Column(length = 16)
    private String status;

    @OneToMany(mappedBy = "product")
    Set<Cart> carts;

}
