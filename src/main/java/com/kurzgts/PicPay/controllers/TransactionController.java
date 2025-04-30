package com.kurzgts.PicPay.controllers;


import com.kurzgts.PicPay.dto.TransferDTO;
import com.kurzgts.PicPay.dtov2.TransferDTOV2;
import com.kurzgts.PicPay.models.Transaction;
import com.kurzgts.PicPay.models.User;
import com.kurzgts.PicPay.services.TransactionService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
@Tag(name = "Transactions", description = "Endpoints for transaction management")
public class TransactionController {
    @Autowired
    TransactionService service;

    @PostMapping("v1")
    @Hidden
//    @Operation(
//            summary = "Cria transação",
//            description = "realiza uma nova transação e persiste no Banco de Dados"
//    )
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransferDTO dto){
        Transaction transaction = service.makeTransaction(dto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(transaction.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping("v2")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Criar transação",
                content = @Content(schema = @Schema(implementation = TransferDTOV2.class))
            )
    })
    public ResponseEntity<Transaction> createTransactionV2(@RequestBody TransferDTOV2 dto){
        Transaction transaction = service.makeTransactionV2(dto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(transaction.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    //TODO


}
