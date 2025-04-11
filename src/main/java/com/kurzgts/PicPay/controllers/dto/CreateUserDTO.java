package com.kurzgts.PicPay.controllers.dto;

import com.kurzgts.PicPay.models.UserTypes;

public record CreateUserDTO(String name, String email, UserTypes userTypes, String cpf, String password) {

}
