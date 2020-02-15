package uk.co.dave.consumer.fxrate.channels;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface FxRateConsumerBinding {

  String AVRO_FX_RATES_IN = "avroFxRatesIn";

  @Input(AVRO_FX_RATES_IN)
  SubscribableChannel avroFxRatesIn();


  String FX_RATES_IN = "fxRates2In";

  @Input(FX_RATES_IN)
  SubscribableChannel fxRates2In();

}
