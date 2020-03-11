package uk.co.dave.producer.fxrate;

import static uk.co.dave.producer.fxrate.FxRateProducerBinding.*;

import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.test.binder.TestSupportBinderAutoConfiguration;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import uk.co.dave.consumer.fxrate.consumer.json.JsonFxRateEvent;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {FxRateProducerApplication.class}, webEnvironment = WebEnvironment.NONE)
@EnableAutoConfiguration(exclude = TestSupportBinderAutoConfiguration.class)
@ActiveProfiles("producer")
@Slf4j
public class JsonFxRatePublisher {
  @Autowired
  private @Output(JSON_FX_RATE_BATCH_OUT) MessageChannel jsonFxRateBatchOut;
  
  @Autowired
  private @Output(JSON_FX_RATE_OUT) MessageChannel jsonFxRateOut;

  @Test
  public void sendJsonFxRateEventForever() throws InterruptedException {
    while (true) {
      JsonFxRateEvent event = new JsonFxRateEvent("GBP", "USD", BigDecimal.valueOf(123.45));
      final Message<JsonFxRateEvent> message = MessageBuilder.withPayload(event).setHeaderIfAbsent(KafkaHeaders.MESSAGE_KEY, JsonFxRateEvent.class.getSimpleName()).build();
      this.jsonFxRateBatchOut.send(message);
      this.jsonFxRateOut.send(message);
      log.info("Message sent to binding");
      Thread.sleep(1000);
    }
  }

  @Test
  public void sendLotsOfJsonFxRateEvents() throws InterruptedException {
    for (int i = 0; i < 1; i++) {
      JsonFxRateEvent event = new JsonFxRateEvent("GBP", "USD", BigDecimal.valueOf(123.45));
      final Message<JsonFxRateEvent> message = MessageBuilder.withPayload(event).setHeaderIfAbsent(KafkaHeaders.MESSAGE_KEY, JsonFxRateEvent.class.getSimpleName()).build();
      this.jsonFxRateBatchOut.send(message);
      this.jsonFxRateOut.send(message);
    }
  }

}
