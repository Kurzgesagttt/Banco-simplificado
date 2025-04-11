package com.kurzgts.PicPay.services;

import com.kurzgts.PicPay.controllers.dto.CreateUserDTO;
import com.kurzgts.PicPay.controllers.mapper.CreateUserMapper;
import com.kurzgts.PicPay.models.User;
import com.kurzgts.PicPay.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public User createUser(User user){
        if(user == null){
            throw new MethodArgumentNotValidException();
        }
        //criptografa a senha para colocar no banco
        //user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }




}
