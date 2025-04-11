package com.kurzgts.PicPay.repositories;

import com.kurzgts.PicPay.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
