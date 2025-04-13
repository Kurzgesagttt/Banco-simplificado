package com.kurzgts.PicPay.controllers;


import com.kurzgts.PicPay.models.Transfer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfers")
public class TransferController {

    @PostMapping
    public ResponseEntity<Transfer> createTransfer(){
        //TODO


        return ResponseEntity.ok().build();
    }



}
