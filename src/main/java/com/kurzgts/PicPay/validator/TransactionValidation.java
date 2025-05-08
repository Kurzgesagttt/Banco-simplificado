package com.kurzgts.PicPay.validator;

import com.kurzgts.PicPay.exceptions.OperacaoNaoPermitidaException;
import com.kurzgts.PicPay.exceptions.RefusedTransactionException;
import com.kurzgts.PicPay.models.User;
import com.kurzgts.PicPay.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class TransactionValidation {

    @Autowired
    RestTemplate restTemplate;

    public void validateTransfer(User sender, User receiver, Double value) {

        if (value == null || value <= 0) {
            throw new IllegalArgumentException("Valor da transferencia deve ser maior que zero");
        }

        if (!authorizationRequestApi()) {
            throw new OperacaoNaoPermitidaException("Operacao nao autorizada");
        }

        if ("MERCHANT".equals(sender.getUserType())) {
            throw new IllegalArgumentException("Lojistas nao podem realizar transferencias");
        }

        if (sender.getBalance() < value) {
            throw new IllegalArgumentException("Sem saldo suficiente para realizar a transferencia");
        }

        if (sender.getId().equals(receiver.getId())) {
            throw new IllegalArgumentException("Voce nao pode fazer uma transferencia para voce mesmo");
        }
    }


    public boolean authorizationRequestApi(){
        String url = "https://util.devi.tools/api/v2/authorize";
        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
        if(response.getStatusCode() == HttpStatus.OK){
            String message = (String) response.getBody().get("status");
            return "success".equalsIgnoreCase(message);
        }else {
            throw new RefusedTransactionException("Transação nao permitida");
        }
     }
}
