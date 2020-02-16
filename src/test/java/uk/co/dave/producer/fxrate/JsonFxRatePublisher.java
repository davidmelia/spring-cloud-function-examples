package uk.co.dave.producer.fxrate;

import static uk.co.dave.producer.fxrate.FxRateProducerBinding.FX_RATE_OUT;

import java.math.BigDecimal;
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
import uk.co.dave.consumer.fxrate.consumer.json.JsonFxRateEvent;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {FxRateProducerApplication.class}, webEnvironment = WebEnvironment.NONE)
@EnableAutoConfiguration
@ActiveProfiles("producer")
@Slf4j
public class JsonFxRatePublisher {
  @Autowired
  private @Output(FX_RATE_OUT) MessageChannel fxRate2Out;


  @Test
  public void sendJsonFxRateEventForever() throws InterruptedException {
    while (true) {
      JsonFxRateEvent event = new JsonFxRateEvent("GBP", "USD", BigDecimal.valueOf(123.45));
      final Message<JsonFxRateEvent> message = MessageBuilder.withPayload(event).setHeaderIfAbsent(KafkaHeaders.MESSAGE_KEY, JsonFxRateEvent.class.getSimpleName()).build();
      this.fxRate2Out.send(message);
      log.info("Message sent to binding");
      Thread.sleep(1000);
    }
  }

}
