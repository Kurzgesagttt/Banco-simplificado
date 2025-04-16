package com.kurzgts.PicPay.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "transaction_id")
    private UUID id;

    @Column(name = "sender",nullable = false)
    private UUID sender;

    @Column(name = "receiver",nullable = false)
    private UUID receiver;

    @CreationTimestamp
    @Column(name = "creation_date")
    private LocalDateTime createdAt;

    @Column(name = "value",nullable = false)
    private Double value;

    @Column(name = "realized",nullable = false)
    private boolean realized;

    public Transaction(UUID id, LocalDateTime createdAt, UUID sender, UUID receiver, Double value, boolean realized) {
        this.id = id;
        this.createdAt = createdAt;
        this.sender = sender;
        this.receiver = receiver;
        this.value = value;
        this.realized = realized;
    }

    public Transaction() {
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

    public boolean isRealized() {
        return realized;
    }

    public void setStatus(boolean realized) {
        this.realized = realized;
    }


}
