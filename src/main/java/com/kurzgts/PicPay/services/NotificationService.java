package com.kurzgts.PicPay.services;

import com.kurzgts.PicPay.dtov2.CreateMailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {

    @Autowired
    RestTemplate restTemplate;

    @Async(value = "emailSenderThread")
    public void enviarNotificacao(String email, String assunto, String mensagem) {
        String url = "";
        CreateMailDTO dto = new CreateMailDTO();
        dto.setMailTo(email);
        dto.setSubject(assunto);
        dto.setContent(mensagem);
        //FIXME
        restTemplate.put(url,dto);
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