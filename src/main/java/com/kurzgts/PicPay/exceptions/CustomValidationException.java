package com.kurzgts.PicPay.exceptions;

import java.util.Map;

public class CustomValidationException extends RuntimeException {
    public CustomValidationException(String message){
        super(message);
    }

}