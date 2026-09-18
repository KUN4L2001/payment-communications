package com.payment.communications.consumer;

import com.payment.communications.dto.MailEvent;
import com.payment.communications.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MailEventConsumer {

  @Autowired private MailService mailService;

  @KafkaListener(topics = "mail-events", groupId = "payment-communication-group")
  public void consume(MailEvent mailEvent) {
    log.info("Link: {}", mailEvent.getEmail());
    mailService.sendMail(mailEvent);
    log.info("Email sent for {}", mailEvent.getEmail());
  }
}
