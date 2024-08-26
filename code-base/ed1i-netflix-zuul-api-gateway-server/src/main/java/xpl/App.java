package xpl;
//import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class App {
   public static void main(String[] args) {
      SpringApplication.run(App.class, args);
   }

   //For distributed tracing using sleuth
//   @Bean
//   public Sampler defaultSampler() {
//      return Sampler.ALWAYS_SAMPLE;
//   }
}
