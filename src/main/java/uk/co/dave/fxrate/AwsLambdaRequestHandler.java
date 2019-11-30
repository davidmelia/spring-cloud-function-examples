package uk.co.dave.fxrate;

import com.amazonaws.services.lambda.runtime.events.ScheduledEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

@Slf4j
public class AwsLambdaRequestHandler extends SpringBootRequestHandler<ScheduledEvent, String> {
  public AwsLambdaRequestHandler() {
    super(FxRateProducerApplication.class);
    log.info("FxRateProducerRequestHandler()");
  }
}
