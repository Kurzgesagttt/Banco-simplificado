package com.kurzgts.PicPay.services;

import com.kurzgts.PicPay.dto.TransferDTO;
import com.kurzgts.PicPay.exceptions.UserNotFoundException;
import com.kurzgts.PicPay.models.User;
import com.kurzgts.PicPay.repositories.TransactionRepository;
import com.kurzgts.PicPay.repositories.UserRepository;
import com.kurzgts.PicPay.validator.TransactionValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transferRepository;
    @Autowired
    UserRepository userRepository
    @Autowired
    TransactionValidation transactionValidation;

    public TransferDTO makeTransfer(TransferDTO dto){

        User sender = transactionValidation.findByCpf(dto.senderCpf())
                .orElseThrow(() -> new UserNotFoundException("Sender not found"));
        User receiver = transactionValidation.f(dto.receiverCpf())
                .orElseThrow(() -> new UsernameNotFoundException("Receiver not found"));
        //valida se todas as regras de negocio para transacao estao corretas
        transactionValidation.validateTransfer(sender, receiver, dto.value());


        sender.setBalance(sender.getBalance() - dto.value());
        receiver.setBalance(receiver.getBalance() + dto.value());
        userRepository.save(sender);
        userRepository.save()

    }



}
