package com.teammealkit.mealkit.products.domain;

import jdk.jfr.Timestamp;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "products")
@Data
public class Products {
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
    private Integer viewCount;

    @Column(name = "sales_cnt")
    private Integer salesCount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "reg_date")
    public Date regDate;

    @Column(length = 16)
    private String status;

    @ManyToMany
    @JoinTable(name = "cart", joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "product_id"))

    private List<Products> products = new ArrayList<Products>();
}
