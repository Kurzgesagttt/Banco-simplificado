package com.kurzgts.PicPay.repositories;

import com.kurzgts.PicPay.models.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransferRepository extends JpaRepository<Transfer, UUID> {
}
