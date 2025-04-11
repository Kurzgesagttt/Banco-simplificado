package com.kurzgts.PicPay.services;

import com.kurzgts.PicPay.controllers.dto.CreateUserDTO;
import com.kurzgts.PicPay.controllers.mapper.CreateUserMapper;
import com.kurzgts.PicPay.exceptions.CustomValidationException;
import com.kurzgts.PicPay.models.User;
import com.kurzgts.PicPay.repositories.UserRepository;
import com.kurzgts.PicPay.validator.UserValidator;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserRepository repository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    UserValidator validator;

    public User createUser(User user){
        //TODO

        //fazer o User Validator
        //criptografa a senha para colocar no banco
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }




}
