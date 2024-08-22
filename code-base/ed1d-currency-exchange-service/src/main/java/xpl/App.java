package xpl;
//import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import static xpl.uty.Colors.*;

@SpringBootApplication
@EnableDiscoveryClient
public class App {
   public static void main(String[] args) {
      SpringApplication.run(App.class, args);
      pp("ed1d-currency-exchange-service");
   }

   //For distributed tracing using sleuth
//   @Bean
//   public Sampler defaultSampler() {
//      return Sampler.ALWAYS_SAMPLE;
//   }
}
