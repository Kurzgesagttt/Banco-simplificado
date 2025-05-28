package com.kurzgts.PicPay.dtov2;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonPropertyOrder({"mail", "subject", "content"})
public class CreateMailDTO implements Serializable {

     @JsonProperty("mail")
     private String mailTo;
     private String subject;
     private String content;

     public CreateMailDTO(String mailTo, String subject, String content) {
          this.mailTo = mailTo;
          this.subject = subject;
          this.content = content;
     }

     public CreateMailDTO() {
     }

     public String getMailTo() {
          return mailTo;
     }

     public void setMailTo(String mailTo) {
          this.mailTo = mailTo;
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
