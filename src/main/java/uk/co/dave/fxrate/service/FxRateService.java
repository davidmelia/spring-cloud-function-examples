package uk.co.dave.fxrate.service;

import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uk.co.dave.fxrate.domain.FxRate;
import uk.co.dave.fxrate.publisher.FxRatePublisher;

@Slf4j
@Service
public class FxRateService {

  private final FxRatePublisher publisher;

  public FxRateService(final FxRatePublisher publisher) {
    this.publisher = publisher;
  }

  public void publishLatestFxRates() {
    log.info("In publishLatestFxRates");
    this.publisher.publish(new FxRate("GBP", "USD", BigDecimal.valueOf(123.45)));

    log.info("Out publishLatestFxRates");
  }


}
