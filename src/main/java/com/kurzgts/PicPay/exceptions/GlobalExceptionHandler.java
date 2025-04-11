package com.kurzgts.PicPay.exceptions;

import com.kurzgts.PicPay.controllers.dto.ErroResponseDTO;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> genericHandlerException(Exception e) {
        ErroResponseDTO erroResponseDTO = new ErroResponseDTO("Entre em contato com administrator", 500);
        return ResponseEntity
                .status(500)
                .body(erroResponseDTO.message());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        for(FieldError error :ex.getBindingResult().getFieldErrors() ){
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(errors);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErroResponseDTO> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        String message = "A constraint violation occurred: " + ex.getMostSpecificCause().getMessage();
        ErroResponseDTO erroResponseDTO = new ErroResponseDTO(message, HttpStatus.CONFLICT.value());
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(erroResponseDTO);
    }
}
