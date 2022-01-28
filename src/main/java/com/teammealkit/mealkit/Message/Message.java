package com.teammealkit.mealkit.Message;

import lombok.Data;

@Data
public class Message {
    private int status;
    private StatusEnum message;
    private Object data;

    public Message() {
        this.status = StatusEnum.BAD_REQUEST.getStatusCode();
        this.message = StatusEnum.BAD_REQUEST;
        this.data = null;
    }
}