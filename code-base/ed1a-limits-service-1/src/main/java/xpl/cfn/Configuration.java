package xpl.cfn;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limits-service")
public class Configuration {
   @Getter
   @Setter
   private int maximum;
   @Getter
   @Setter
   private int minimum;
}
