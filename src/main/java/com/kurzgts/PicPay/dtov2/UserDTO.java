package com.kurzgts.PicPay.dtov2;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.kurzgts.PicPay.models.UserTypes;
import io.swagger.v3.oas.annotations.Hidden;

@JsonFilter("userFilter")
@Hidden
public class UserDTO{

    private String name;
    private String email;
    private UserTypes userType;
    private String cpf;
    private String password;
    private Double balance;

    public UserDTO() {
    }

    public UserDTO(Double balance, String password, String cpf, UserTypes userType, String email, String name) {
        this.balance = balance;
        this.password = password;
        this.cpf = cpf;
        this.userType = userType;
        this.email = email;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
