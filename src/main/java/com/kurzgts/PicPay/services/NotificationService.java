package com.kurzgts.PicPay.services;

import com.kurzgts.PicPay.dtov2.CreateMailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${spring.application.mail-ip}")
    private String mail;

    @Async(value = "emailSenderThread")
    public void enviarNotificacao(String email, String assunto, String mensagem) {
        String url = "http://"+mail+":8081/mail";
        CreateMailDTO dto = new CreateMailDTO(email, mensagem, assunto);
        dto.setSenderEmail(email);
        dto.setSubject(assunto);
        dto.setContent(mensagem);
        //FIXME
        restTemplate.postForEntity(url, dto, String.class);
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