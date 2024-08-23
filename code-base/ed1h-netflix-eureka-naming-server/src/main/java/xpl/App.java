package xpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import static xpl.uty.Colors.*;

@SpringBootApplication
@EnableEurekaServer
public class App {
   public static void main(String[] args) {
      SpringApplication.run(App.class, args);
   }
}
