

:newspaper: **ed1a-limits-service get configuration form application properties** .. 

:one: application properties  
```properties
spring.application.name=limits-service
limits-service.minimum=9
limits-service.maximum=999
```
:two: model using lombok
```java
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class LimitConfiguration {
   @Getter
   private int maximum;
   @Getter
   private int minimum;
}
```
:three: configurure properties
```java
@Component
//limits-service is the prefix for properties in the configuration file.
@ConfigurationProperties("limits-service")
public class Configuration {
```
:four: app
```java
@RestController
public class LimitsConfigurationController {

   @Autowired
   Configuration configuration;

   @GetMapping("/limits")
   public LimitConfiguration retrieveLimitsFromConfigurations() {
      return new LimitConfiguration(configuration.getMaximum(),configuration.getMinimum());
   }
}
```  
:five: run   
```http
http://localhost:8080/limits
```
----------




  
  

