package com.kurzgts.PicPay.controllers;

//import com.kurzgts.PicPay.dto.CreateUserDTO;

import com.kurzgts.PicPay.docs.UserControllerDocs;
import com.kurzgts.PicPay.dtov2.CreateUserDTO;
import com.kurzgts.PicPay.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@Tag(name = "User", description = "Endpoints for user management")
public class UserController implements UserControllerDocs {

    @Autowired
    UserService  service;

    @GetMapping
    @Override
    public ResponseEntity<List<CreateUserDTO>> getAllUsers(){
        List<CreateUserDTO> list = service.getAllUsers();
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("{id}")
    @Override
    public ResponseEntity<Void> deleteUser(@PathVariable("id") String id){
        UUID uuid = UUID.fromString(id);
        service.deleteUser(uuid);
        return ResponseEntity.noContent().build();
    }

}
