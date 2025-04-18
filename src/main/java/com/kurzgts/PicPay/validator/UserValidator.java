package com.kurzgts.PicPay.validator;

import com.kurzgts.PicPay.exceptions.RegistroDuplicadoException;
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
        if(existeUserCadastrado(user)){
            throw new RegistroDuplicadoException("Usuário já cadastrado");
        }
    }
    private boolean existeUserCadastrado(User user) {
        Optional<User> userEncontado =  repository.findByCpf(user.getCpf());
        return userEncontado.isPresent() && (user.getId() == null || !user.getId().equals(userEncontado.get().getId()));
    }
}
