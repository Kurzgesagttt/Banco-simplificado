package com.kurzgts.PicPay.repositories;

import com.kurzgts.PicPay.models.Transfer;
import com.kurzgts.PicPay.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TransferRepository extends JpaRepository<Transfer, UUID> {
    Optional<User> findByCpf(String cpf);
}
