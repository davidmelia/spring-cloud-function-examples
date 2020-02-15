package uk.co.dave.producer.fxrate;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface FxRateProducerBinding {

  String AVRO_FX_RATE_OUT = "avroFxRateOut";

  @Output(AVRO_FX_RATE_OUT)
  MessageChannel avroFxRateOut();


  String FX_RATE_OUT = "fxRate2Out";

  @Output(FX_RATE_OUT)
  MessageChannel fxRate2Out();

}
