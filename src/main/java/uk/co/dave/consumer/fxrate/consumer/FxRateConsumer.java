package uk.co.dave.consumer.fxrate.consumer;

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
public class FxRateConsumer {

  private final AcknowledgementHelper acknowledgementHelper;

  @StreamListener(FxRateConsumerBinding.JSON_FX_RATES_IN)
  public void consumeJson(JsonFxRateEvent event, @Headers MessageHeaders headers) {
    acknowledgementHelper.acknowledge(headers);
    log.info("jsonFxRateEvent = event={},{}", event);
  }

  @StreamListener(FxRateConsumerBinding.AVRO_FX_RATES_IN)
  public void consumeAvro(AvroFxRateEvent event, @Headers MessageHeaders headers) {
    acknowledgementHelper.acknowledge(headers);
    log.info("avroFxRateEvent = event={},{}", event);
  }

}
