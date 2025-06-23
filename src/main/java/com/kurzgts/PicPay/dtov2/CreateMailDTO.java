package com.kurzgts.PicPay.dtov2;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;
@JsonPropertyOrder({"mail", "subject", "content"})
public class CreateMailDTO implements Serializable {

     @JsonProperty("mail")
     @Email
     @NotBlank(message = "Campo email vazio")
     private String receiverEmail;

     @JsonProperty("subject")
     private String subject;

     @JsonProperty("body")
     @NotBlank(message = "Não é possível enviar o email sem um corpo de mensagem")
     private String content;

     public CreateMailDTO(String senderEmail, String content, String subject) {
          this.receiverEmail = senderEmail;
          this.content = content;
          this.subject = subject;
     }

     public String getSenderEmail() {
          return receiverEmail;
     }

     public void setSenderEmail(String senderEmail) {
          this.receiverEmail = senderEmail;
     }

     public String getSubject() {
          return subject;
     }

     public void setSubject(String subject) {
          this.subject = subject;
     }

     public String getContent() {
          return content;
     }

     public void setContent(String content) {
          this.content = content;
     }

}
