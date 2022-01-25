package com.teammealkit.mealkit.client.dto;

import com.teammealkit.mealkit.client.domain.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class ClientCreateDTO {
    private String email;
    private String pw;
    private String name;
//    private LocalDateTime reg_date;
    private Date birthday;
    private String address;
    private String phone;
    private Long buy_cnt;
    private String role;

    public Client toEntity() {
        return Client.builder()
                .email(this.email)
                .pw(this.pw)
                .name(this.name)
//                .reg_date(this.reg_date)
                .birthday(this.birthday)
                .address(this.address)
                .phone(this.phone)
                .buy_cnt(this.buy_cnt)
                .role(this.role)
                .build();
    }
}
