package uk.co.dave.fxrate;

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
import uk.co.dave.fxrate.channels.FxRateBinding;
import uk.co.dave.fxrate.service.FxRateService;


/**
 * Two options to make a Spring Cloud Stream 2 project work in Spring Cloud Stream 3 <br/>
 * 1) add @SpringBootApplication(exclude = FunctionConfiguration.class) <br/>
 * 2) add a Bean called output()
 */
@SpringBootApplication
@EnableSchemaRegistryClient
@EnableBinding(FxRateBinding.class)
@Slf4j
public class FxRateProducerApplication {
  public static void main(String[] args) {
    SpringApplication.run(FxRateProducerApplication.class, args);
  }

  @Bean
  public Function<Flux<ScheduledEvent>, Flux<String>> function(FxRateService fxRateService) {
    return flux -> flux.doOnNext(t -> {
      log.info("****SPRING CLOUD FUNCTION 3 ****");
    }).delaySequence(Duration.ofSeconds(5)).doOnNext(t -> log.info("Waiting Over.")).flatMap(x -> Mono.just("OK"));
  }

}
