package com.teammealkit.mealkit.client.dto;

import com.teammealkit.mealkit.client.domain.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class ClientCreateDTO {
    private String email;
    private String pw;
    private String name;
    private Date reg_date;
    private LocalDate birthday;
    private String address;
    private String phone;
    private Long buy_cnt;
    private String role;

    public Client toEntity() {
        return Client.builder()
                .email(this.email)
                .password(this.pw)
                .userName(this.name)
                .birthDay(this.birthday)
                .address(this.address)
                .phone(this.phone)
                .buyCnt(this.buy_cnt)
                .role(this.role)
                .build();
    }
}
