package com.kurzgts.PicPay.controllers;


//import com.kurzgts.PicPay.dto.TransferDTO;
import com.kurzgts.PicPay.dtov2.TransferDTOV2;
import com.kurzgts.PicPay.models.Transaction;
import com.kurzgts.PicPay.services.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/transaction")
@Tag(name = "Transactions", description = "Endpoints for transaction management")
public class TransactionController {
    @Autowired
    TransactionService service;

//    @PostMapping("v1")
//    @Operation(
//            summary = "Cria transação V1",
//            description = "realiza uma nova transação e persiste no Banco de Dados V1",
//            tags = {"Transactions", "V1"},
//            responses = {
//                    @ApiResponse(
//                            description = "Transação criada com sucesso",
//                            responseCode = "201",
//                            content = @Content(mediaType = "application/json",schema = @Schema(implementation = Transaction.class))
//                    )
//            }
//    )
//    public ResponseEntity<Transaction> createTransaction(@RequestBody TransferDTO dto){
//        Transaction transaction = service.makeTransaction(dto);
//
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//                .buildAndExpand(transaction.getId()).toUri();
//        return ResponseEntity.created(location).build();
//    }

    @PostMapping("v2")
    @Operation(
            summary = "Cria transação",
            description = "realiza uma nova transação e persiste no Banco de Dados",
            tags = {"Transactions","V2"},
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "201",
                            content = @Content(mediaType = "application/json",schema = @Schema(implementation = TransferDTOV2.class))
                    ),
                    @ApiResponse(
                            description = "Not found",
                            responseCode = "404",
                            content = @Content
                    ),
                    @ApiResponse(
                            description = "Unouthorized",
                            responseCode = "500",
                            content = @Content
                    )
            }
    )
    public ResponseEntity<Transaction> createTransactionV2(@RequestBody TransferDTOV2 dto){
        Transaction transaction = service.makeTransactionV2(dto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(transaction.getId()).toUri();
        return ResponseEntity.created(location).build();
    }



    @GetMapping
    @Operation(
            description = "return a list of transaction DTOs",
            summary = "Get All transactions"
    )
    public ResponseEntity<List<TransferDTOV2>> getAllTransactions(){
        List<TransferDTOV2> list = service.getAllTransaction();
        return ResponseEntity.ok(list);
    }
}
