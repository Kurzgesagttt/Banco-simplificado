package com.kurzgts.PicPay.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.Hidden;

@Hidden
public record TransferDTO(
        //troca o nome do campo do json que vem no body
        @JsonProperty("senderCpf") String senderCpf, @JsonProperty("receiverCpf")String receiverCpf, @JsonProperty("value")Double value) {
}


