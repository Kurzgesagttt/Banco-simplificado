package com.kurzgts.PicPay.services;

import com.kurzgts.PicPay.dto.TransferDTO;
import com.kurzgts.PicPay.exceptions.UserNotFoundException;
import com.kurzgts.PicPay.models.Transaction;
import com.kurzgts.PicPay.models.User;
import com.kurzgts.PicPay.repositories.TransactionRepository;
import com.kurzgts.PicPay.repositories.UserRepository;
import com.kurzgts.PicPay.validator.TransactionValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TransactionValidation transactionValidation;
    @Autowired
    NotificationService notificationService;

    public Transaction makeTransaction(TransferDTO dto){
        Transaction transaction = new Transaction();
        User sender = userRepository.findByCpf(dto.senderCpf())
                .orElseThrow(() -> new UserNotFoundException("Sender not found"));
        User receiver = userRepository.findByCpf(dto.receiverCpf())
                .orElseThrow(() -> new UsernameNotFoundException("Receiver not found"));
        //valida se todas as regras de negocio para transacao estao corretas
        transactionValidation.validateTransfer(sender, receiver, dto.value());

        //atualiza dados para adicionar no banco transactions
        transaction.setSender(sender.getId());
        transaction.setReceiver(receiver.getId());
        transaction.setValue(dto.value());
        transaction.setStatus(true);
        transactionRepository.save(transaction);
        //atualiza o saldo do usuario
        sender.setBalance(sender.getBalance() - dto.value());
        userRepository.save(sender);
        //atualiza o saldo do usuario
        receiver.setBalance(receiver.getBalance() + dto.value());
        userRepository.save(receiver);

        notificationService.enviarNotificacao(sender.getEmail(), "Transferência realizada com sucesso", "Você transferiu R$" + dto.value() + " para " + receiver.getName());
        //TODO enviar notificação para o receiver

        return transaction;

    }



}
