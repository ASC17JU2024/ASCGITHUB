package xpl.cfn;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// This annotation is used to indicate that the class is a Spring Bean
@Component
// This annotation is used to map the properties in the application.properties file to the fields in the class
@ConfigurationProperties("limits-service")
public class Configuration {
   @Getter
   @Setter
   private int maximum;
   @Getter
   @Setter
   private int minimum;
}