package uk.co.dave.producer.fxrate;

import static uk.co.dave.producer.fxrate.FxRateProducerBinding.AVRO_FX_RATE_OUT;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import uk.co.dave.consumer.fxrate.consumer.avro.AvroFxRate;
import uk.co.dave.consumer.fxrate.consumer.avro.AvroFxRateEvent;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {FxRateProducerApplication.class}, webEnvironment = WebEnvironment.NONE)
@EnableAutoConfiguration
@ActiveProfiles("producer")
@Slf4j
public class AvroFxRatePublisher {
  @Autowired
  private @Output(AVRO_FX_RATE_OUT) MessageChannel avroFxRateOut;


  @Test
  public void sendAvroFxRateEventForever() throws InterruptedException {
    while (true) {
      AvroFxRateEvent event = new AvroFxRateEvent(List.of(AvroFxRate.newBuilder().setFrom("USD").setTo("GBP").setRate(new BigDecimal(0.770045).setScale(6, RoundingMode.HALF_UP)).build()));
      final Message<AvroFxRateEvent> message = MessageBuilder.withPayload(event).setHeaderIfAbsent(KafkaHeaders.MESSAGE_KEY, AvroFxRate.class.getSimpleName()).build();
      this.avroFxRateOut.send(message);
      log.info("Message sent to binding");
      Thread.sleep(1000);
    }
  }

  @Test
  public void sendLotsOfAvroFxRateEvents() throws InterruptedException {
    for (int i = 0; i < 100000; i++) {
      AvroFxRateEvent event = new AvroFxRateEvent(List.of(AvroFxRate.newBuilder().setFrom("USD").setTo("GBP").setRate(new BigDecimal(0.770045).setScale(6, RoundingMode.HALF_UP)).build()));
      final Message<AvroFxRateEvent> message = MessageBuilder.withPayload(event).setHeaderIfAbsent(KafkaHeaders.MESSAGE_KEY, AvroFxRate.class.getSimpleName()).build();
      this.avroFxRateOut.send(message);
    }
  }

}
