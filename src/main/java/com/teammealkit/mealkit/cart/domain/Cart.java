package com.teammealkit.mealkit.cart.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num")
    private Long num;

    @Column(name = "c_num")
    private Long clientNum;

    @Column(name = "p_num")
    private Long productNum;


}
