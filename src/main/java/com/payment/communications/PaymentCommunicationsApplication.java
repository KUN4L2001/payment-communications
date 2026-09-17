package com.payment.communications;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class PaymentCommunicationsApplication {

  public static void main(String[] args) {
    SpringApplication.run(PaymentCommunicationsApplication.class, args);
  }
}
