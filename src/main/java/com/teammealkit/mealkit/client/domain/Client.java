package com.teammealkit.mealkit.client.domain;

import com.teammealkit.mealkit.BaseTimeEntity;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter @Setter
@Builder
@AllArgsConstructor
@DynamicUpdate
// 도메인 sweager 해야함
public class Client extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column(length = 32, nullable = false)
    private String email;

    @Column(length = 128, nullable = false)
    private String password;

    @Column(name = "user_name", length = 16, nullable = false)
    private String userName;

    @Column(name = "birth_day", length = 16)
    private LocalDate birthDay;

    @Column(length = 128)
    private String address;

    @Column(length = 16)
    private String phone;

    @Column(name = "buy_cnt", length = 8, columnDefinition = "default 0")
    private Long buyCnt;

    @Column(length = 8, columnDefinition = "default '회원'")
    private String role;
}
