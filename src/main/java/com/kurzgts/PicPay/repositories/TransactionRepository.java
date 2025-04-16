package com.kurzgts.PicPay.repositories;

import com.kurzgts.PicPay.models.Transaction;
import com.kurzgts.PicPay.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
    Optional<User> findByCpf(String cpf);
}
