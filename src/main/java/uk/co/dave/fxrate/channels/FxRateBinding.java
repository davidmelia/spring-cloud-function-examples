package uk.co.dave.fxrate.channels;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface FxRateBinding {

  String FX_RATE_OUT = "fxRate2Out";

  @Output(FX_RATE_OUT)
  MessageChannel fxRate2Out();

  String FX_RATES_IN = "fxRates2In";

  @Input(FX_RATES_IN)
  SubscribableChannel fxRates2In();

}
