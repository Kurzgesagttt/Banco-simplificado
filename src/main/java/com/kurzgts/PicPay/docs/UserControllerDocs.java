package com.kurzgts.PicPay.docs;

import com.kurzgts.PicPay.dtov2.CreateUserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserControllerDocs {
    //TODO
    @Operation(
            summary = "Get all users",
            description = "Get all users, no filter",
            tags = {"User"},
            responses = {
                    @ApiResponse(responseCode = "200",description = "Success",
                            content = @Content(array = @ArraySchema(schema = @Schema(implementation = CreateUserDTO.class)))
                    ),
                    @ApiResponse(responseCode = "500",description = "Server Error",
                            content = @Content)
                }
            )
    ResponseEntity<List<CreateUserDTO>> getAllUsers();

    @Operation(
            summary = "Deleta um usuario por UUID",
            description = "Valida se o usuario existe e se o saldo é igual a zero antes de deletar",
            tags = {"User"},
            responses = {
                    @ApiResponse(responseCode = "204",description = "Success, No Content",
                    content = @Content)
            }
    )
    ResponseEntity<Void> deleteUser(@PathVariable("id") String id);
}
