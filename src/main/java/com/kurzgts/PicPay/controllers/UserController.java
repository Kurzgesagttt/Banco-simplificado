package com.kurzgts.PicPay.controllers;

import com.kurzgts.PicPay.controllers.dto.CreateUserDTO;
import com.kurzgts.PicPay.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {



    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserDTO user){


        return ResponseEntity.ok().build();
    }

}
