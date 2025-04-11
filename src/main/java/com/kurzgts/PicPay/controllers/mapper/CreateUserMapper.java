package com.kurzgts.PicPay.controllers.mapper;

import com.kurzgts.PicPay.controllers.dto.CreateUserDTO;
import com.kurzgts.PicPay.models.User;

import java.time.LocalDateTime;
import java.util.UUID;

public class CreateUserMapper {
    public static User toEntity(CreateUserDTO userDTO) {
        return new User(
                userDTO.name(),userDTO.email(),
                userDTO.password(), userDTO.cpf(),
                userDTO.userType()
        );
    }
}
