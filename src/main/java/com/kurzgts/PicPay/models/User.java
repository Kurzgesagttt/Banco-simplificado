package com.kurzgts.PicPay.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email",nullable = false,unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type",nullable = false)
    private UserTypes userType;

    @Column(name = "cpf",nullable = false,unique = true)
    private String cpf;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "balance",nullable = false)
    private Double balance;

    @CreationTimestamp
    @Column(name = "create_date",nullable = false)
    private LocalDateTime createdAt;

    public User(String name,String email,String password, String cpf, UserTypes userType) {
        this.balance = 0.0d;
        this.password = password;
        this.cpf = cpf;
        this.userType = userType;
        this.name = name;
        this.email = email;
    }

    public User() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public UserTypes getUserType() {
        return userType;
    }

    public void setUserType(UserTypes userType) {
        this.userType = userType;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
