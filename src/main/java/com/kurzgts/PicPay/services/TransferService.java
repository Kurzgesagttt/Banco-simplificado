package com.kurzgts.PicPay.services;

import com.kurzgts.PicPay.repositories.TransferRepository;
import com.kurzgts.PicPay.validator.TransferValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferService {

    @Autowired
    TransferRepository repository;
    @Autowired
    TransferValidation transferValidation;

}
