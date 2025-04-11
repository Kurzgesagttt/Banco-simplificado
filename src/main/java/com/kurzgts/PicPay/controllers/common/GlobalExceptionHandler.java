package com.kurzgts.PicPay.controllers.common;

import com.kurzgts.PicPay.controllers.dto.ErroResponseDTO;
import com.kurzgts.PicPay.exceptions.CustomValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ErroResponseDTO genericHandlerException(Exception e) {
        ErroResponseDTO erroResponseDTO = new ErroResponseDTO("Entre em contato com administrator", 500);
        //TODO
    }

}
