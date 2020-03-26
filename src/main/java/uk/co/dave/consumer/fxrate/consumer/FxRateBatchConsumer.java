package uk.co.dave.consumer.fxrate.consumer;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;
import uk.co.dave.consumer.fxrate.channels.FxRateConsumerBinding;
import uk.co.dave.consumer.fxrate.consumer.avro.AvroFxRateEvent;
import uk.co.dave.consumer.fxrate.consumer.json.JsonFxRateEvent;


@Slf4j
@Component
@AllArgsConstructor
public class FxRateBatchConsumer {

  private final AcknowledgementHelper acknowledgementHelper;

  @StreamListener(FxRateConsumerBinding.JSON_FX_RATES_BATCH_IN)
  public void consumeJsonBatch(final List<JsonFxRateEvent> events, @Headers MessageHeaders headers) {
    log.info("jsonFxRateEvents = size={}", events.size());
    acknowledgementHelper.acknowledge(headers);
  }

  /**
   * This does NOT work for the FxRateConsumerTest - is batch mode supported via spring cloud contract
   *
   * @param events
   * @param headers
   */
  @StreamListener(FxRateConsumerBinding.AVRO_FX_RATES_BATCH_IN)
  public void consumeAvroBatch(final List<AvroFxRateEvent> events, @Headers MessageHeaders headers) {
    log.info("avroFxRateEvents = size={}", events.size());
    acknowledgementHelper.acknowledge(headers);
  }


}
