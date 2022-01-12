package com.teammealkit.mealkit.client.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long num;

    @Column(length = 32, nullable = false)
    private String id;

    @Column(length = 32, nullable = false)
    private String pw;

    @Column(length = 16, nullable = false)
    private String name;
}
