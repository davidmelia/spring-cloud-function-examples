package uk.co.dave.producer.fxrate;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface FxRateProducerBinding {

  String AVRO_FX_RATE_BATCH_OUT = "avroFxRateBatchOut";

  @Output(AVRO_FX_RATE_BATCH_OUT)
  MessageChannel avroFxRateBatchOut();
  
  String AVRO_FX_RATE_OUT = "avroFxRateOut";

  @Output(AVRO_FX_RATE_OUT)
  MessageChannel avroFxRateOut();


  String JSON_FX_RATE_BATCH_OUT = "jsonFxRateBatchOut";

  @Output(JSON_FX_RATE_BATCH_OUT)
  MessageChannel jsonFxRateBatchOut();
  
  String JSON_FX_RATE_OUT = "jsonFxRateOut";

  @Output(JSON_FX_RATE_OUT)
  MessageChannel jsonFxRateOut();

}
