package com.kurzgts.PicPay.controllers;


//import com.kurzgts.PicPay.dto.TransferDTO;
import com.kurzgts.PicPay.dtov2.CreateTransferDTOV2;
import com.kurzgts.PicPay.models.Transaction;
import com.kurzgts.PicPay.services.TransactionService;
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
public class TransactionController implements com.kurzgts.PicPay.docs.TransactionControllerDocs {
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

    @PostMapping
    @Override
    public ResponseEntity<Transaction> createTransactionV2(@RequestBody CreateTransferDTOV2 dto){
        Transaction transaction = service.makeTransactionV2(dto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(transaction.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    @Override
    public ResponseEntity<List<CreateTransferDTOV2>> getAllTransactions(){
        List<CreateTransferDTOV2> list = service.getAllTransaction();
        return ResponseEntity.ok(list);
    }
}
