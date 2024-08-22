package xpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static xpl.uty.Colors.pp;

@SpringBootApplication
public class App {
   public static void main(String[] args) {
      SpringApplication.run(App.class, args);
      pp("ed1e-currency-conversion-service");
   }
}
