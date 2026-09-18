package com.payment.communications.service;

import com.payment.communications.dto.MailEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {

  private final JavaMailSender mailSender;

  public void sendMail(MailEvent mailEvent) {

    SimpleMailMessage message = new SimpleMailMessage();

    message.setTo(mailEvent.getEmail());
    message.setSubject(mailEvent.getSubject());
    message.setText(mailEvent.getMessage() + "\n\nPayment Link: " + mailEvent.getLink());

    mailSender.send(message);
  }
}
