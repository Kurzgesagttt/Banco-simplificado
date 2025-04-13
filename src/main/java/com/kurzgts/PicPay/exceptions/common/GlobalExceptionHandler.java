package com.kurzgts.PicPay.exceptions.common;

import com.kurzgts.PicPay.controllers.dto.ErroResponseDTO;
import com.kurzgts.PicPay.exceptions.CustomValidationException;
import com.kurzgts.PicPay.exceptions.OperacaoNaoPermitidaException;
import com.kurzgts.PicPay.exceptions.RegistroDuplicadoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErroResponseDTO> genericHandlerException(Exception e, WebRequest request) {
        ErroResponseDTO response = new ErroResponseDTO(e.getMessage(), request.getDescription(false), new Date());
        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(OperacaoNaoPermitidaException.class)
    public final ResponseEntity<ErroResponseDTO> operacaoNaoPermitidaException(OperacaoNaoPermitidaException e, WebRequest request) {
        ErroResponseDTO response = new ErroResponseDTO(e.getMessage(), request.getDescription(false),new Date());
        return new ResponseEntity<>(response,HttpStatus.CONFLICT);
    }
    @ExceptionHandler(RegistroDuplicadoException.class)
    public final ResponseEntity<ErroResponseDTO> registroDuplicadoException(RegistroDuplicadoException e, WebRequest request) {
        ErroResponseDTO response = new ErroResponseDTO(e.getMessage(), request.getDescription(false), new Date());
        return new ResponseEntity<>(response,HttpStatus.CONFLICT);
    }
}
