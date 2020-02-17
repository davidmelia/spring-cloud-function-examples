package uk.co.dave.consumer.fxrate;

import com.amazonaws.services.lambda.runtime.events.ScheduledEvent;
import java.time.Duration;
import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class DelayFunction implements Function<Flux<ScheduledEvent>, Flux<String>> {

  @Override
  public Flux<String> apply(Flux<ScheduledEvent> event) {
    return event.doOnNext(t -> {
      log.info("****SPRING CLOUD FUNCTION 3 ****");
    }).delaySequence(Duration.ofMinutes(5)).doOnNext(t -> log.info("Waiting Over.")).flatMap(x -> Mono.just("OK"));
  }

}
