package com.kurzgts.PicPay.controllers;

import com.kurzgts.PicPay.dto.CreateUserDTO;
import com.kurzgts.PicPay.dtov2.CreateUserDTOV2;
import com.kurzgts.PicPay.dtov2.UserDTO;
import com.kurzgts.PicPay.mapper.ObjectMapper;
import com.kurzgts.PicPay.models.User;
import com.kurzgts.PicPay.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user")
@Tag(name = "User", description = "Endpoints for user management")
public class UserController {

    @Autowired
    UserService  service;

    @PostMapping
    //@RequestMapping("/v1")
    @Operation(
            summary = "Create User",
            description = "Cria User",
            tags = {"User", "V1"},
            responses = {
                    @ApiResponse(responseCode = "201", description = "Success",
                            content = @Content(schema = @Schema(implementation = CreateUserDTO.class))
                    )
            }
    )
    public ResponseEntity<User> createUser(@Valid @RequestBody CreateUserDTOV2 user){
        User newUser = ObjectMapper.parseObject(user, User.class);
        User createdUser = service.createUser(newUser);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    //TODO
    @GetMapping
    @Operation(
            summary = "Get all users",
            description = "Get all users, no filter",
            tags = {"User"},
            responses = {
                    @ApiResponse(responseCode = "200",description = "Success",
                            content = @Content(array = @ArraySchema(schema = @Schema(implementation = UserDTO.class)))
                    ),
                    @ApiResponse(responseCode = "500",description = "Server Error",
                            content = @Content)
                }
            )
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> list = service.getAllUsers();
        return ResponseEntity.ok(list);
    }

}
