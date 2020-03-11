package uk.co.dave;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.cloud.contract.stubrunner.StubTrigger;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import uk.co.dave.consumer.fxrate.FxRateConsumerApplication;
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {FxRateConsumerApplication.class}, webEnvironment = WebEnvironment.NONE)
@AutoConfigureStubRunner(stubsMode = StubsMode.CLASSPATH, ids = {"uk.co.dave:fx-producer:+:stubs"})
@ActiveProfiles("consumer")
public class FxRateConsumerSandpit {

  @Autowired
  private StubTrigger stubTrigger;


  @Autowired
  private MessageCollector messageCollector;

  @BeforeEach
  public void setUp() {
    assertThat(messageCollector).isNotNull();
  }

  @Test
  public void testAvroFxRateEvent() {
    stubTrigger.trigger("triggerAvroFxRateEvent");
  }

  @Test
  public void testJsonFxRateEvent() {
    stubTrigger.trigger("triggerJsonFxRateEvent");
  }
}
