package com.kurzgts.PicPay.controllers;

//import com.kurzgts.PicPay.dto.CreateUserDTO;

import com.kurzgts.PicPay.docs.UserControllerDocs;
import com.kurzgts.PicPay.dtov2.CreateUserDTO;
import com.kurzgts.PicPay.mapper.ObjectMapper;
import com.kurzgts.PicPay.models.User;
import com.kurzgts.PicPay.services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/user")
@Tag(name = "User", description = "Endpoints for user management")
public class UserController implements UserControllerDocs {

    @Autowired
    UserService service;

    @Override
    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody CreateUserDTO dto){
        User user = ObjectMapper.parseObject(dto, User.class);
        service.createUser(user);
        return ResponseEntity.created(null).build();
    }

    @GetMapping
    @Override
    public ResponseEntity<List<CreateUserDTO>> getAllUsers(){
        List<CreateUserDTO> list = service.getAllUsers();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreateUserDTO> getUserById(@PathVariable("id") String id ){
        UUID uuid = UUID.fromString(id);
        User user = service.getUserById(uuid);
        CreateUserDTO dto = ObjectMapper.parseObject(user, CreateUserDTO.class);
        user.add(linkTo(methodOn(UserController.class).getUserById(id)).withSelfRel());
        user.add(linkTo(methodOn(UserController.class).getAllUsers()).withRel("all-users"));
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("{id}")
    @Override
    public ResponseEntity<Void> deleteUser(@PathVariable("id") String id){
        UUID uuid = UUID.fromString(id);
        service.deleteUser(uuid);
        return ResponseEntity.noContent().build();
    }

}
