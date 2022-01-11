package com.teammealkit.mealkit.products.domain;

import jdk.jfr.Timestamp;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "products")
@Data
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
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
    private String img_main;

    @Column(name = "img_content",length = 256)
    private String img_content;

    @Column(name = "content",length = 256)
    private String content;

    @Column(name = "view_cnt")
    private Integer view_count;

    @Column(name = "sales_cnt")
    private Integer sales_count;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "reg_date")
    private Date reg_date;

    @Column(length = 16)
    private String status;
}
