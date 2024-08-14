package xpl.ctr;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xpl.cfn.Configuration;
import xpl.mdl.LimitConfiguration;

@RestController
public class LimitsConfigurationController {
   @Autowired
   Configuration configuration;

   @GetMapping("/fault-tolerance-example")
   @HystrixCommand(defaultFallback = "fallbackRetrieveConfiguration")
   public LimitConfiguration retrieveConfiguration() {
      throw new RuntimeException("Not available");
   }

   public LimitConfiguration fallbackRetrieveConfiguration() {
      return new LimitConfiguration(999, 9);
   }

   @GetMapping("/limits")
   public LimitConfiguration retrieveLimitsFromConfigurations() {
      return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
   }
}
