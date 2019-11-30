package uk.co.dave.fxrate.channels;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface FxRateBinding {

  String FX_RATE_OUT = "fxRateOut";

  @Output(FX_RATE_OUT)
  MessageChannel fxRateOut();

}
