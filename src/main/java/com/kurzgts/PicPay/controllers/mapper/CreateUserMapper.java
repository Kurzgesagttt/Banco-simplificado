package com.kurzgts.PicPay.controllers.mapper;

import com.kurzgts.PicPay.controllers.dto.CreateUserDTO;
import com.kurzgts.PicPay.models.User;

public class CreateUserMapper {
    public static User toEntity(CreateUserDTO userDTO){
        return new User(
                userDTO.name(),
                userDTO.email(),
                userDTO.userTypes(),
                userDTO.cpf(),
                userDTO.password()
        );
    };


}
