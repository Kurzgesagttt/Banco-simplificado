package com.kurzgts.PicPay.controllers.common;

import com.kurzgts.PicPay.controllers.dto.ErroResponseDTO;
import com.kurzgts.PicPay.exceptions.CustomValidationException;
import com.kurzgts.PicPay.exceptions.OperacaoNaoPermitidaException;
import com.kurzgts.PicPay.exceptions.RegistroDuplicadoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ErroResponseDTO genericHandlerException(Exception e) {
        return new ErroResponseDTO("Entre em contato com adm", HttpStatus.INTERNAL_SERVER_ERROR.value(), List.of());
    }

    @ExceptionHandler(OperacaoNaoPermitidaException.class)
    public ErroResponseDTO operacaoNaoPermitidaException(OperacaoNaoPermitidaException e) {
        return ErroResponseDTO.respostaPadrao(e.getMessage());
    }
    @ExceptionHandler(RegistroDuplicadoException.class)
    public ErroResponseDTO registroDuplicadoException(RegistroDuplicadoException ex) {
        return ErroResponseDTO.conflito(ex.getMessage());
    }
}
