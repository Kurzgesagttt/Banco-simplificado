package com.kurzgts.PicPay.docs;

import com.kurzgts.PicPay.dtov2.CreateTransferDTOV2;
import com.kurzgts.PicPay.models.Transaction;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface TransactionControllerDocs {
    @Operation(
            summary = "Cria transação",
            description = "realiza uma nova transação e persiste no Banco de Dados",
            tags = {"Transactions"},
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "201",
                            content = @Content(mediaType = "application/json",schema = @Schema(implementation = CreateTransferDTOV2.class))
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
    ResponseEntity<Transaction> createTransactionV2(@RequestBody CreateTransferDTOV2 dto);

    @Operation(
            description = "return a list of transaction DTOs",
            summary = "Get All transactions",
            tags = {"Transactions"}
    )
    ResponseEntity<List<CreateTransferDTOV2>> getAllTransactions();
}
