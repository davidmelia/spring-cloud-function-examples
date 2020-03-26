package uk.co.dave.producer.fxrate;

import static uk.co.dave.producer.fxrate.FxRateProducerBinding.AVRO_FX_RATE_BATCH_OUT;
import static uk.co.dave.producer.fxrate.FxRateProducerBinding.AVRO_FX_RATE_OUT;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import uk.co.dave.consumer.fxrate.consumer.avro.AvroFxRateEvent;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {FxRateProducerApplication.class}, webEnvironment = WebEnvironment.NONE)
// @EnableAutoConfiguration(exclude = TestSupportBinderAutoConfiguration.class)
@ActiveProfiles("producer")
@Slf4j
public class AvroFxRatePublisher {
  @Autowired
  private @Output(AVRO_FX_RATE_BATCH_OUT) MessageChannel avroFxRateBatchOut;
  @Autowired
  private @Output(AVRO_FX_RATE_OUT) MessageChannel avroFxRateOut;

  @Test
  public void sendAvroFxRateEventForever() throws InterruptedException {
    while (true) {
      AvroFxRateEvent event =
          AvroFxRateEvent.newBuilder().setFrom("USD").setTo("GBP").setRate(new BigDecimal(0.770045).setScale(6, RoundingMode.HALF_UP)).setTimestamp(LocalDateTime.now().toString()).build();
      final Message<AvroFxRateEvent> message = MessageBuilder.withPayload(event).setHeaderIfAbsent(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString()).build();
      this.avroFxRateBatchOut.send(message);
      this.avroFxRateOut.send(message);
      log.info("Message sent to binding");
      Thread.sleep(1000);
    }
  }

  @Test
  public void sendLotsOfAvroFxRateEvents() throws InterruptedException {
    for (int i = 0; i < 10; i++) {
      AvroFxRateEvent event =
          AvroFxRateEvent.newBuilder().setFrom("USD").setTo("GBP").setRate(new BigDecimal(0.770045).setScale(6, RoundingMode.HALF_UP)).setTimestamp(LocalDateTime.now().toString()).build();
      final Message<AvroFxRateEvent> message = MessageBuilder.withPayload(event).setHeaderIfAbsent(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString()).build();
      this.avroFxRateOut.send(message);
    }
  }

  @Test
  public void sendLotsOfBatchAvroFxRateEvents() throws InterruptedException {
    for (int i = 0; i < 100000; i++) {
      AvroFxRateEvent event =
          AvroFxRateEvent.newBuilder().setFrom("USD").setTo("GBP").setRate(new BigDecimal(0.770045).setScale(6, RoundingMode.HALF_UP)).setTimestamp(LocalDateTime.now().toString()).build();
      final Message<AvroFxRateEvent> message = MessageBuilder.withPayload(event).setHeaderIfAbsent(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString()).build();
      this.avroFxRateBatchOut.send(message);
    }
  }

}
