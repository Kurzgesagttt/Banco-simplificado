package com.kurzgts.PicPay.dtov2;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.Hidden;

import java.io.Serializable;

@JsonPropertyOrder({"sender", "receiver", "value"})
@Hidden
public class CreateTransferDTOV2 implements Serializable {

    @JsonProperty("sender")
    private String senderCpf;
    @JsonProperty("receiver")
    private String receiverCpf;
    @JsonProperty("value")
    private Double value;

    public CreateTransferDTOV2(String senderCpf, String receiverCpf, Double value) {
        this.senderCpf = senderCpf;
        this.receiverCpf = receiverCpf;
        this.value = value;
    }

    public CreateTransferDTOV2() {
    }

    public String getReceiverCpf() {
        return receiverCpf;
    }

    public void setReceiverCpf(String receiverCpf) {
        this.receiverCpf = receiverCpf;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getSenderCpf() {
        return senderCpf;
    }

    public void setSenderCpf(String senderCpf) {
        this.senderCpf = senderCpf;
    }
}
