package uk.co.dave.consumer.fxrate.consumer;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;
import uk.co.dave.consumer.fxrate.channels.FxRateConsumerBinding;
import uk.co.dave.consumer.fxrate.domain.FxRate;


@Slf4j
@Component
@AllArgsConstructor
public class FxRateConsumer {

  @StreamListener(FxRateConsumerBinding.FX_RATES_IN)
  public void consume(final List<FxRate> events, @Headers MessageHeaders headers) {
    log.info("fxRateEvents = {}", events, headers);
    Acknowledgment ack = headers.get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
    ack.acknowledge();
  }
}
