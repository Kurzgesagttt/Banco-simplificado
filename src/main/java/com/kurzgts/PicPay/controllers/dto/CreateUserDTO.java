package com.kurzgts.PicPay.controllers.dto;

import com.kurzgts.PicPay.models.UserTypes;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateUserDTO(@NotBlank(message = "Campo Nome vazio")
                            String name,
                            @Email
                            @NotBlank(message = "Campo email vazio")
                            String email,
                            @NotBlank(message = "Campo senha vazio")
                            String password,
                            @NotBlank(message = "Campo CPF vazio")
                            String cpf,
                            UserTypes userType) {
}
