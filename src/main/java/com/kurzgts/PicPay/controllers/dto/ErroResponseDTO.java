package com.kurzgts.PicPay.controllers.dto;

import org.springframework.http.HttpStatus;

import java.util.List;

public record ErroResponseDTO(String message, int statusCode, List<ErroCampo> erros) {

    public static ErroResponseDTO respostaPadrao(String mensagem){
        return new ErroResponseDTO( mensagem,  HttpStatus.BAD_REQUEST.value(),List.of());
    }

    public static ErroResponseDTO conflito(String mensagem){
        return new ErroResponseDTO(mensagem, HttpStatus.CONFLICT.value(), List.of());
    }
}
