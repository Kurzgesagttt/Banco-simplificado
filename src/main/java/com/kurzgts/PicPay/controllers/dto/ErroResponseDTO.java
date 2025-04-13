package com.kurzgts.PicPay.controllers.dto;

import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;

public record ErroResponseDTO(String message, String details, Date date) {

}
