package xpl.pxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import xpl.mdl.CurrencyConversion;

//@FeignClient
@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
public interface CurrencyExchangeServiceProxy {
   @GetMapping("/currency-exchange/from/{from}/to/{to}")
   CurrencyConversion retrieveExchangeValue(@PathVariable("from") String from,
                                            @PathVariable("to") String to);
}
