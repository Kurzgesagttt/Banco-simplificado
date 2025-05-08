package com.kurzgts.PicPay.dtov2;

import com.kurzgts.PicPay.models.UserTypes;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;


@Hidden
public class CreateUserDTOV2 implements Serializable {
    @NotBlank(message = "Campo Nome vazio")
    private String name;

    @Email
    @NotBlank(message = "Campo email vazio")
    private String email;

    @NotBlank(message = "Campo senha vazio")
    private String password;

    @NotBlank(message = "Campo CPF vazio")
    private String cpf;

    private UserTypes userType;

    public CreateUserDTOV2() {
    }

    public CreateUserDTOV2(String name, String email, String password, String cpf, UserTypes userType) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
        this.userType = userType;
    }

    // Getters e Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public UserTypes getUserType() {
        return userType;
    }

    public void setUserType(UserTypes userType) {
        this.userType = userType;
    }
}
