package com.kurzgts.PicPay.controllers;


import com.kurzgts.PicPay.dto.TransferDTO;
import com.kurzgts.PicPay.models.Transfer;
import com.kurzgts.PicPay.services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfers")
public class TransferController {

    @Autowired
    TransferService service;

    @PostMapping
    public ResponseEntity<Transfer> createTransfer(@RequestBody TransferDTO dto){



        return ResponseEntity.status(HttpStatus.CREATED).build();
    }



}
