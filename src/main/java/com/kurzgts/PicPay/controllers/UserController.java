package com.kurzgts.PicPay.controllers;

import com.kurzgts.PicPay.dto.CreateUserDTO;
import com.kurzgts.PicPay.dtov2.CreateUserDTOV2;
import com.kurzgts.PicPay.mapper.ObjectMapper;
import com.kurzgts.PicPay.models.User;
import com.kurzgts.PicPay.services.UserService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/user")
@Tag(name = "User", description = "Endpoints for user management")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping
    //@RequestMapping("/v1")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Criar novo Usuário",
                content = @Content(schema = @Schema(implementation = CreateUserDTO.class))
            )
    })
    @Parameter
    public ResponseEntity<User> createUser(@Valid @RequestBody CreateUserDTOV2 user){
        User newUser = ObjectMapper.parseObject(user, User.class);
        User createdUser = service.createUser(newUser);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    //TODO

}
