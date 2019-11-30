package uk.co.dave.fxrate;

import com.amazonaws.services.lambda.runtime.events.ScheduledEvent;
import org.junit.Test;
import uk.co.dave.fxrate.AwsLambdaRequestHandler;

public class AwsLambdaRequestHandlerTest {

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
