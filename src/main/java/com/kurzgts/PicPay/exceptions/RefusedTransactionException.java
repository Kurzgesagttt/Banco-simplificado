package com.kurzgts.PicPay.exceptions;

public class RefusedTransactionException extends RuntimeException {
    public RefusedTransactionException(String message) {
        super(message);
    }
}
