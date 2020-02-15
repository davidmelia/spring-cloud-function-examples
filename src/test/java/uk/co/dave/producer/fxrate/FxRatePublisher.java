package uk.co.dave.producer.fxrate;

import static uk.co.dave.producer.fxrate.FxRateProducerBinding.FX_RATE_OUT;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import uk.co.dave.consumer.fxrate.consumer.json.JsonFxRateEvent;

@Component
@Slf4j
public class FxRatePublisher {

  private final MessageChannel fxRate2Out;

  public FxRatePublisher(@Output(FX_RATE_OUT) final MessageChannel fxRate2Out) {
    this.fxRate2Out = fxRate2Out;
  }

  public void publish(final JsonFxRateEvent event) {
    final Message<JsonFxRateEvent> message = MessageBuilder.withPayload(event).setHeaderIfAbsent(KafkaHeaders.MESSAGE_KEY, JsonFxRateEvent.class.getSimpleName()).build();
    try {
      this.fxRate2Out.send(message);
      log.info("Message sent to binding");
    } catch (final Throwable th) {
      log.error("Exception occurred while sending message to the channel {} root cause is {}", FX_RATE_OUT, th.getCause().getMessage());
      throw new RuntimeException(th);
    }
  }
}
