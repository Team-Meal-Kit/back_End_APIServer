package com.teammealkit.mealkit.Message;

import lombok.Data;

@Data
public class Message2 {
    private int status;
    private StatusEnum message;

    public Message2() {
        this.status = StatusEnum.BAD_REQUEST.getStatusCode();
        this.message = StatusEnum.BAD_REQUEST;
    }
}
