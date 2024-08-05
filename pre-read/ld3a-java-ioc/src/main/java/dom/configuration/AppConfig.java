package dom.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//Indicates that a class declares one or more @Bean methods and 
//may be processed by the Spring container to generate bean definitions and 
//service requests for those beans at runtime
@Configuration
@ComponentScan("dom")
public class AppConfig {
}
