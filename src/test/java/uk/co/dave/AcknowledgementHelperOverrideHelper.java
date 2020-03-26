package uk.co.dave;

import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import uk.co.dave.consumer.fxrate.consumer.AcknowledgementHelper;

@TestConfiguration
public class AcknowledgementHelperOverrideHelper {

  @Bean
  public AcknowledgementHelper acknowledgementHelper() {
    return Mockito.mock(AcknowledgementHelper.class);
  }

}
