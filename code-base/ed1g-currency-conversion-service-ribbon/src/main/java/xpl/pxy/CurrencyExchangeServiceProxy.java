package xpl.pxy;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import xpl.mdl.CurrencyConversion;


@FeignClient(name = "currency-exchange-service")
//@FeignClient(name = "netflix-zuul-api-gateway-server")
//@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
// USING API GATEWAY
@GetMapping("/currency-exchange/from/{from}/to/{to}")
//   @GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
   CurrencyConversion retrieveExchangeValue(@PathVariable("from") String from,
                                            @PathVariable("to") String to);
}
//@FeignClient
//obsolete : url will be configured in properties file
//@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
//obsolete : feign client configured to use zuul api gateway
//@FeignClient(name = "currency-exchange-service")
// public interface CurrencyExchangeServiceProxy {
//    @GetMapping("/currency-exchange/from/{from}/to/{to}")
//    CurrencyConversion retrieveExchangeValue(@PathVariable("from") String from,
//                                             @PathVariable("to") String to);
// }
