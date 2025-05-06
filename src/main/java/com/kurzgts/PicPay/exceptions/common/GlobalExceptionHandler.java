package com.kurzgts.PicPay.exceptions.common;

import com.kurzgts.PicPay.dtov2.ErroResponseDTOV2;
import com.kurzgts.PicPay.exceptions.OperacaoNaoPermitidaException;
import com.kurzgts.PicPay.exceptions.RefusedTransactionException;
import com.kurzgts.PicPay.exceptions.RegistroDuplicadoException;
import com.kurzgts.PicPay.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErroResponseDTOV2> genericHandlerException(Exception e, WebRequest request) {
        ErroResponseDTOV2 response = new ErroResponseDTOV2(e.getMessage(), request.getDescription(false), new Date());
        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(OperacaoNaoPermitidaException.class)
    public final ResponseEntity<ErroResponseDTOV2> operacaoNaoPermitidaException(OperacaoNaoPermitidaException e, WebRequest request) {
        ErroResponseDTOV2 response = new ErroResponseDTOV2(e.getMessage(), request.getDescription(false),new Date());
        return new ResponseEntity<>(response,HttpStatus.CONFLICT);
    }
    @ExceptionHandler(RegistroDuplicadoException.class)
    public final ResponseEntity<ErroResponseDTOV2> registroDuplicadoException(RegistroDuplicadoException e, WebRequest request) {
        ErroResponseDTOV2 response = new ErroResponseDTOV2(e.getMessage(), request.getDescription(false), new Date());
        return new ResponseEntity<>(response,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErroResponseDTOV2> userNotFoundHandler(UserNotFoundException ex, WebRequest request){
        ErroResponseDTOV2 restponse = new ErroResponseDTOV2(ex.getMessage(), request.getDescription(false), new Date());
        return new ResponseEntity<>(restponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public final ResponseEntity<ErroResponseDTOV2> illegalArgumentException(IllegalArgumentException ex,WebRequest request){
        ErroResponseDTOV2 response = new ErroResponseDTOV2(ex.getMessage(),request.getDescription(false),new Date());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(RefusedTransactionException.class)
    public final ResponseEntity<ErroResponseDTOV2> refusedTransactionException(RefusedTransactionException ex,WebRequest request){
        ErroResponseDTOV2 response = new ErroResponseDTOV2(ex.getMessage(),request.getDescription(false),new Date());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
}
