package com.teammealkit.mealkit.client.dto;

import com.teammealkit.mealkit.client.domain.Client;
import com.teammealkit.mealkit.client.role.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class ClientCreateDTO {
    private String email;
    private String pw;
    private String userName;
    private LocalDate birthDay;
    private String address;
    private String phone;
    private Long buyCnt;
    private UserRole role;

    public Client toEntity() {
        return Client.builder()
                .email(this.email)
                .pw(this.pw)
                .userName(this.userName)
                .birthDay(this.birthDay)
                .address(this.address)
                .phone(this.phone)
                .buyCnt(this.buyCnt)
                .role(this.role)
                .build();
    }
}
