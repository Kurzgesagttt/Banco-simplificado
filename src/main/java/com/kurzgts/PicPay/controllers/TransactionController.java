package com.kurzgts.PicPay.controllers;


import com.kurzgts.PicPay.dto.TransferDTO;
import com.kurzgts.PicPay.dtov2.TransferDTOV2;
import com.kurzgts.PicPay.models.Transaction;
import com.kurzgts.PicPay.services.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService service;

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransferDTO dto){
        Transaction transaction = service.makeTransaction(dto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(transaction.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping()
    @RequestMapping("/v2")
    public ResponseEntity<Transaction> createTransactionV2(@RequestBody TransferDTOV2 dto){
        Transaction transaction = service.makeTransactionV2(dto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(transaction.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    //TODO


}
