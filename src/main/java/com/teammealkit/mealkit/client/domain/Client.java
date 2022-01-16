package com.teammealkit.mealkit.client.domain;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.sql.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter @Setter
@Builder
@AllArgsConstructor
@DynamicUpdate
// 도메인 sweager 해야함
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(length = 32, nullable = false)
    private String email;

    @Column(length = 32, nullable = false)
    private String pw;

    @Column(length = 16, nullable = false)
    private String name;

    @Column(length = 16, nullable = false)
    private Date reg_date;

    @Column(length = 16, nullable = false)
    private Date birthday;

    @Column(length = 128, nullable = false)
    private String address;

    @Column(length = 16, nullable = false)
    private String phone;

    @Column(length = 8, nullable = false)
    private Long buy_cnt;

    @Column(length = 8, nullable = false)
    private String role;
}
