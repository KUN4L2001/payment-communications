package com.payment.communications.config;

import com.payment.communications.dto.MailEvent;
import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JacksonJsonDeserializer;

@Configuration
public class KafkaConsumerConfig {

  @Bean
  public ConsumerFactory<String, MailEvent> consumerFactory() {

    JacksonJsonDeserializer<MailEvent> jsonDeserializer =
        new JacksonJsonDeserializer<>(MailEvent.class);

    jsonDeserializer.setUseTypeHeaders(false);

    Map<String, Object> config = new HashMap<>();

    config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

    config.put(ConsumerConfig.GROUP_ID_CONFIG, "payment-communication-group");

    config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

    config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

    return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), jsonDeserializer);
  }

  @Bean(name = "kafkaListenerContainerFactory")
  public ConcurrentKafkaListenerContainerFactory<String, MailEvent>
      kafkaListenerContainerFactory() {

    ConcurrentKafkaListenerContainerFactory<String, MailEvent> factory =
        new ConcurrentKafkaListenerContainerFactory<>();

    factory.setConsumerFactory(consumerFactory());

    return factory;
  }
}
