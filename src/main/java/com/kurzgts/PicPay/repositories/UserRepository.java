package com.kurzgts.PicPay.repositories;

import com.kurzgts.PicPay.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByNameAndEmailAndCpf(String name, String email, String cpf);

}
