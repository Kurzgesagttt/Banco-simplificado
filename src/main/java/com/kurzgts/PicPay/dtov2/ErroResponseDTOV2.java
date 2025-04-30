package com.kurzgts.PicPay.dtov2;

import io.swagger.v3.oas.annotations.Hidden;

import java.util.Date;

@Hidden
public class ErroResponseDTOV2 {

    private String message;
    private String details;
    private Date date;

    public ErroResponseDTOV2() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
