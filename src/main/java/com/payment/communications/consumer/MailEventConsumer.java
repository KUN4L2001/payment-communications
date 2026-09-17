package com.payment.communications.consumer;

import com.payment.communications.dto.MailEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MailEventConsumer {

  @KafkaListener(topics = "mail-events", groupId = "payment-communication-group")
  public void consume(MailEvent mailEvent) {

    System.out.println("Received mail event:");
    System.out.println("Transaction ID: " + mailEvent.getTransactionId());
    System.out.println("Email: " + mailEvent.getEmail());
    System.out.println("Subject: " + mailEvent.getSubject());
    System.out.println("Message: " + mailEvent.getMessage());

    // TODO: Send email here
  }
}
