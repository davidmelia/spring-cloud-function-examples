package uk.co.dave.consumer.fxrate.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

@Component("acknowledgementHelper")
@Slf4j
public class AcknowledgementHelper {

  public void acknowledge(MessageHeaders headers) {
    Acknowledgment ack = headers.get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
    try {
      ack.acknowledge();
    } catch (Exception e) {
      log.error("Acknowledgement error rolling back.", e);
      throw e;
    }
  }

}
