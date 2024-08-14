package xpl.cfn;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// @Component
// @ConfigurationProperties("limits-service")
// public class Configuration {
//
//    @Getter
//    @Setter
//    private int maximum;
//    @Getter
//    @Setter
//    private int minimum;
// }
@Component
//limits-service is the prefix for properties in the configuration file.
@ConfigurationProperties("limits-service")
public class Configuration {

   private int minimum;
   private int maximum;

   public void setMinimum(int minimum) {
      this.minimum = minimum;
   }

   public void setMaximum(int maximum) {
      this.maximum = maximum;
   }

   public int getMinimum() {
      return minimum;
   }

   public int getMaximum() {
      return maximum;
   }
}
