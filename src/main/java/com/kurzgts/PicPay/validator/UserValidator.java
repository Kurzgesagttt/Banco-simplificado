package com.kurzgts.PicPay.validator;

import com.kurzgts.PicPay.exceptions.RegistroDuplicadoException;
import com.kurzgts.PicPay.exceptions.UserNotFoundException;
import com.kurzgts.PicPay.models.User;
import com.kurzgts.PicPay.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

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

    public void deleteValidation(UUID id){
        Optional<User> userEncontado =  repository.findById(id);
        if(userEncontado.isEmpty()){
            throw new UserNotFoundException("User not found");
        }
        if(!userEncontado.get().getBalance().equals(0.0)){
            throw new IllegalArgumentException("Balance must be zero");
        }
    }

}
