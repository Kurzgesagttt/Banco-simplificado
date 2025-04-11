package com.kurzgts.PicPay.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "transfers")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "transfer_id")
    private UUID id;

    @Column(name = "sender",nullable = false)
    private UUID sender;

    @Column(name = "receiver",nullable = false)
    private UUID receiver;

    @CreationTimestamp
    @Column(name = "creation_date",nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "value",nullable = false)
    private Double value;

    @Column(name = "status",nullable = false)
    private String status;

    public Transfer(UUID id, LocalDateTime createdAt, UUID sender, UUID receiver, Double value, String status) {
        this.id = id;
        this.createdAt = createdAt;
        this.sender = sender;
        this.receiver = receiver;
        this.value = value;
        this.status = status;
    }

    public Transfer() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public UUID getSender() {
        return sender;
    }

    public void setSender(UUID sender) {
        this.sender = sender;
    }

    public UUID getReceiver() {
        return receiver;
    }

    public void setReceiver(UUID receiver) {
        this.receiver = receiver;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
