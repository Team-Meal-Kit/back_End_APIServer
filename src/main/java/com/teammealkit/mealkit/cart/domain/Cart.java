package com.teammealkit.mealkit.cart.domain;

import com.teammealkit.mealkit.BaseTimeEntity;
import com.teammealkit.mealkit.client.domain.Client;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;

@Entity
@Data
@Table(name = "cart")
public class Cart extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idx")
    private Client client;

    public static Cart createCart(Client client) {
        Cart cart = new Cart();
        cart.setClient(client);
        return cart;
    }

}
