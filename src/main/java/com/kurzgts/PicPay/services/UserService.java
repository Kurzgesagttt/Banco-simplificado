package com.kurzgts.PicPay.services;

import com.kurzgts.PicPay.dtov2.UserDTO;
import com.kurzgts.PicPay.mapper.ObjectMapper;
import com.kurzgts.PicPay.models.User;
import com.kurzgts.PicPay.repositories.UserRepository;
import com.kurzgts.PicPay.validator.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository repository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    UserValidator validator;



    public User createUser(User user){
        validator.validator(user);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setBalance(0.0d);
        return repository.save(user);
    }

    public List<UserDTO> getAllUsers(){
        List<User> list = repository.findAll();
        return ObjectMapper.parseListObjects(list, UserDTO.class);
    }

    public void deleteUser(UUID id){
        validator.deleteValidation(id);
        repository.deleteById(id);
    }
}
