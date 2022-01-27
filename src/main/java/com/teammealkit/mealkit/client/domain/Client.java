package com.teammealkit.mealkit.client.domain;

import com.teammealkit.mealkit.cart.domain.Cart;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Getter @Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx")
    private Long uid;

    @Column(length = 32, nullable = false)
    private String email;

    @Column(length = 32, nullable = false)
    private String pw;

    @Column(length = 16, nullable = false)
    private String name;

    @Column(length = 32, nullable = false)
    private String phone;

    @Column(length = 128, nullable = false)
    private String address;

    @Column(length = 8, nullable = false)
    private String role;

    @Column(name = "buy_cnt", nullable = false)
    private Long buyCount;

    @Column(nullable = false)
    private Date birthday;

    @Column(name = "reg_date", nullable = false)
    private Date regDate;

    @OneToMany
    Set<Cart>carts;
}
