package uk.co.dave.fxrate.consumer;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;
import uk.co.dave.fxrate.channels.FxRateBinding;
import uk.co.dave.fxrate.domain.FxRate;


@Slf4j
@Component
@AllArgsConstructor
public class FxRateConsumer {

  @StreamListener(FxRateBinding.FX_RATES_IN)
  public void consume(final List<FxRate> events, @Headers MessageHeaders headers) {
    log.info("fxRateEvents = {}", events, headers);
    Acknowledgment ack = headers.get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
    ack.acknowledge();
  }
}
