package com.teammealkit.mealkit.Message;

public enum StatusEnum {
    OK(200),
    BAD_REQUEST(400),
    FORBIDDEN(403),
    NOT_FOUND(404),
    INTERNAL_SEVER_ERROR(500);

    int statusCode;

    StatusEnum(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
