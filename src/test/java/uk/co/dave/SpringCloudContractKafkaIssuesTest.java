package uk.co.dave;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.cloud.contract.stubrunner.StubTrigger;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode;
import org.springframework.cloud.stream.binder.test.InputDestination;
import org.springframework.cloud.stream.binder.test.OutputDestination;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import uk.co.dave.consumer.fxrate.FxRateConsumerApplication;
import uk.co.dave.consumer.fxrate.consumer.AcknowledgementHelper;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {FxRateConsumerApplication.class}, webEnvironment = WebEnvironment.NONE)
@AutoConfigureStubRunner(stubsMode = StubsMode.CLASSPATH, ids = {"uk.co.dave:fx-producer:+:stubs"})
@ActiveProfiles("consumer")
@Import({TestChannelBinderConfiguration.class, AcknowledgementHelperOverrideHelper.class})
@TestPropertySource(properties = {"spring.main.allow-bean-definition-overriding=true"})
public class SpringCloudContractKafkaIssuesTest {
  @Autowired
  private StubTrigger stubTrigger;

  @Autowired
  private AcknowledgementHelper mockAcknowledgementHelper;

  @Autowired
  private InputDestination input;

  @Autowired
  private OutputDestination output;

  // @BeforeEach
  // public void setUp() {
  // assertThat(output.receive().getPayload()).isNotNull();
  // }

  // @Test
  // public void testAvroFxRateEvent_FailsBecauseAckIsNull() {
  // stubTrigger.trigger("triggerJsonFxRateEvent");
  // }

  @Test
  public void testAvroFxRateBatchEvent_FailsBecauseBatchExpectsAnArrayButEventsArePublishedIndividually() {
    stubTrigger.trigger("triggerJsonFxRateBatchEvent");
    Assertions.assertEquals("WHATEVER", output.receive().getPayload());
  }


}
