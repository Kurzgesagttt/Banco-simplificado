package com.kurzgts.PicPay.validator;

import com.kurzgts.PicPay.models.User;
import com.kurzgts.PicPay.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserValidator {
    @Autowired
    private UserRepository repository;

    public void validator(User user){
        if(existeAutorCadastrado(user)){
            throw new RuntimeException("Usuário já cadastrado");
        }
    }

    private boolean existeAutorCadastrado(User user) {
        Optional<User> userEncontado =  repository.findByCpf(user.getCpf());
        if(user.getId() == null){
            return userEncontado.isEmpty();
        }

        return !user.getId().equals(userEncontado.get().getId()) && userEncontado.isPresent();
    }






}
