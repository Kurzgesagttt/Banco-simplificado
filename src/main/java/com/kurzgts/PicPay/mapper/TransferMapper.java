package com.kurzgts.PicPay.mapper;

import com.kurzgts.PicPay.dto.TransferDTO;
import com.kurzgts.PicPay.models.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransferMapper {

    @Mapping(source = "sender", target = "senderCpf")
    @Mapping(source = "receiver", target = "receiverCpf")
    TransferDTO toDto(Transaction transfer);
}
