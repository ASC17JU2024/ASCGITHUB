package xpl.ctr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import xpl.ety.ExchangeValue;
import xpl.rpy.ExchangeValueRepository;

@RestController
public class CurrencyExchangeController {

   @Autowired
   Environment environment;
   @Autowired
   ExchangeValueRepository repository;

   //jpa repository exchange value
   @GetMapping(value = "/currency-exchange/from/{from}/to/{to}")
   public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
      int port = Integer.parseInt(environment.getProperty("local.server.port"));
      ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
      exchangeValue.setPort(port);
      System.out.println(exchangeValue.toString());
      return exchangeValue;
   }
   //hard-coded exchange value
   // @GetMapping(value = "/currency-exchange/from/{from}/to/{to}")
   // public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String
   // to) {
   //    int port = Integer.parseInt(environment.getProperty("local.server.port"));
   //    return new ExchangeValue(1000L, from, to, BigDecimal.valueOf(65), port);
   // }
}
