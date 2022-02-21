package com.teammealkit.mealkit.client.domain;

import com.teammealkit.mealkit.Common;
import com.teammealkit.mealkit.client.role.UserRole;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Table(name = "client")
@Getter @Setter
@Builder
@AllArgsConstructor
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
// 도메인 sweager 해야함
public class Client extends Common implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long idx;

    @Column(length = 32, nullable = false)
    private String email;

    @Setter
    @Column(name = "password", length = 128, nullable = false)
    private String pw;

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

    @Setter
    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private UserRole role;
}
