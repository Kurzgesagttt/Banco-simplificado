package com.kurzgts.PicPay.services;

import com.kurzgts.PicPay.exceptions.OperacaoNaoPermitidaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {

    @Autowired
    RestTemplate restTemplate;

    @Async(value = "emailSenderThread")
    public void enviarNotificacao(String destinatario, String assunto, String corpo) {

    }

    //nao utilizado atualmente
//    public boolean authorizationRequestApi() {
//        String url = "https://util.devi.tools/api/v1/notify";
//
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
//        ResponseEntity<Void> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Void.class);
//        return response.getStatusCode() == HttpStatus.NO_CONTENT;
//    }
}