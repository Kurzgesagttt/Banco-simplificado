package com.kurzgts.PicPay.controllers.dto;

public record ErroResponseDTO(String message, int statusCode) {

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
