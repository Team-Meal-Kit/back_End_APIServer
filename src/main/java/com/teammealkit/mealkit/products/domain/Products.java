package com.teammealkit.mealkit.products.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "products")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name", length = 64, nullable = false)
    private String name;

    @Column()
    private Long price;

    @Column()
    private Integer count;

    @Column()
    private Integer discount;

    @Column(length = 256)
    private String img_main;

    @Column(length = 256)
    private String img_content;

    @Column(length = 256)
    private String content;

    @Column()
    private Integer view_cnt;

    @Column()
    private Integer sales_cnt;

    @Column()
    private Date reg_date;

    @Column(length = 16)
    private String status;
}
