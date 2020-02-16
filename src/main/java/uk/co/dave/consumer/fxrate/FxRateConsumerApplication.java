package uk.co.dave.consumer.fxrate;

import com.amazonaws.services.lambda.runtime.events.ScheduledEvent;
import java.time.Duration;
import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.schema.registry.client.EnableSchemaRegistryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uk.co.dave.consumer.fxrate.channels.FxRateConsumerBinding;


/**
 * Two options to make a Spring Cloud Stream 2 project work in Spring Cloud Stream 3 <br/>
 * 1) add @SpringBootApplication(exclude = FunctionConfiguration.class) <br/>
 * 2) add a Bean called output()
 */
@SpringBootApplication
@EnableSchemaRegistryClient
@EnableBinding(FxRateConsumerBinding.class)
@Slf4j
public class FxRateConsumerApplication {
  public static void main(String[] args) {
    SpringApplication.run(FxRateConsumerApplication.class, args);
  }

  @Bean
  public Function<Flux<ScheduledEvent>, Flux<String>> function() {
    return flux -> flux.doOnNext(t -> {
      log.info("****SPRING CLOUD FUNCTION 3 ****");
    }).delaySequence(Duration.ofMinutes(5)).doOnNext(t -> log.info("Waiting Over.")).flatMap(x -> Mono.just("OK"));
  }

}
