package uk.co.dave.consumer.fxrate;

import com.amazonaws.services.lambda.runtime.events.ScheduledEvent;
import org.junit.Test;
import uk.co.dave.consumer.fxrate.AwsLambdaRequestHandler;

public class AwsLambdaRequestHandlerSandpit {

  @Test
  public void test() {
    try (AwsLambdaRequestHandler handler = new AwsLambdaRequestHandler()) {

      Object result = handler.handleRequest(new ScheduledEvent(), null);
      System.out.println("*** result=" + result);
      result = handler.handleRequest(new ScheduledEvent(), null);
      System.out.println("*** result=" + result);
    }

  }

}
