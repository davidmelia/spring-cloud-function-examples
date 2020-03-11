package uk.co.dave.consumer.fxrate.channels;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface FxRateConsumerBinding {

  String AVRO_FX_RATES_BATCH_IN = "avroFxRatesBatchIn";

  @Input(AVRO_FX_RATES_BATCH_IN)
  SubscribableChannel avroFxRatesBatchIn();
  
  String AVRO_FX_RATES_IN = "avroFxRatesIn";

  @Input(AVRO_FX_RATES_IN)
  SubscribableChannel avroFxRatesIn();


  String JSON_FX_RATES_BATCH_IN = "jsonFxRatesBatchIn";

  @Input(JSON_FX_RATES_BATCH_IN)
  SubscribableChannel jsonFxRatesBatchIn();

  String JSON_FX_RATES_IN = "jsonFxRatesIn";

  @Input(JSON_FX_RATES_IN)
  SubscribableChannel jsonFxRatesIn();
}
