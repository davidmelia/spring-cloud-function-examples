package uk.co.dave.consumer.fxrate.consumer;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;
import uk.co.dave.consumer.fxrate.channels.FxRateConsumerBinding;
import uk.co.dave.consumer.fxrate.consumer.avro.AvroFxRateEvent;
import uk.co.dave.consumer.fxrate.consumer.json.JsonFxRateEvent;


@Slf4j
@Component
@AllArgsConstructor
public class FxRateConsumer {


@StreamListener(FxRateConsumerBinding.JSON_FX_RATES_IN)
 public void consumeJson(JsonFxRateEvent event, @Headers MessageHeaders headers) {
  Acknowledgment ack = headers.get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
  ack.acknowledge();
   log.info("jsonFxRateEvent = event={},{}", event, ack);
 }

  @StreamListener(FxRateConsumerBinding.AVRO_FX_RATES_IN)
  public void consumeAvro(AvroFxRateEvent event, @Headers MessageHeaders headers) {
    Acknowledgment ack = headers.get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
    ack.acknowledge();
    log.info("avroFxRateEvent = event={},{}", event, ack);
  }

}
