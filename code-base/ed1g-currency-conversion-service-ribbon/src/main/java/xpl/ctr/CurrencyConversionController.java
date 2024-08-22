package xpl.ctr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import xpl.mdl.CurrencyConversion;
import xpl.pxy.CurrencyExchangeServiceProxy;

import java.math.BigDecimal;

import static xpl.uty.Colors.*;

@RestController
//@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
//@FeignClient(name = "currency-exchange-service")
//@FeignClient(name = "netflix-zuul-api-gateway-server")
//@RibbonClient(name = "currency-conversion-service")
public class CurrencyConversionController {
   private Logger logger = LoggerFactory.getLogger(this.getClass());
   @Autowired
   private CurrencyExchangeServiceProxy proxy;

   @GetMapping(value = "/currency-converter/from/{from}/to/{to}/quantity" + "/{quantity}")
   public CurrencyConversion convertCurrency1(@PathVariable String from, @PathVariable String to,
                                              @PathVariable BigDecimal quantity) {
      py("accessing conversion service through zuul gateway api");
      CurrencyConversion conversion = proxy.retrieveExchangeValue(from, to);
      logger.warn(conversion.toString());
      return new CurrencyConversion(conversion.getId(), from, to,
              conversion.getConversionMultiple(), BigDecimal.valueOf(1000),
              quantity.multiply(conversion.getConversionMultiple()), conversion.getPort());
   }

   //using FeignClient & Proxy & Zuul Api Gateway
   @GetMapping(
           value = "/currency-conversion-service/currency-converter/from/{from}/to/{to}/quantity" +
                   "/{quantity}")
   public CurrencyConversion convertCurrency(@PathVariable String from, @PathVariable String to,
                                             @PathVariable BigDecimal quantity) {
      py("feign+ ribbon cleint using proxy + zuul gateway api");
      CurrencyConversion conversion = proxy.retrieveExchangeValue(from, to);
      return new CurrencyConversion(conversion.getId(), from, to,
              conversion.getConversionMultiple(), BigDecimal.valueOf(1000),
              quantity.multiply(conversion.getConversionMultiple()), conversion.getPort());
   }
   //obsolete using FeignClient & Proxy
   // @GetMapping(value = "/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
   // public CurrencyConversion convertCurrency(@PathVariable String from, @PathVariable String to,
   //                                           @PathVariable BigDecimal quantity) {
   //    py("feign cleint");
   //    CurrencyConversion conversion = proxy.retrieveExchangeValue(from, to);
   //    return new CurrencyConversion(conversion.getId(), from, to,
   //            conversion.getConversionMultiple(), BigDecimal.valueOf(1000),
   //            quantity.multiply(conversion.getConversionMultiple()), conversion.getPort());
   // }
   //obsolete using REST Template : invoking currency exchange service
   // @GetMapping(value = "/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
   // public CurrencyConversion convertCurrency(@PathVariable String from, @PathVariable String to,
   //                                           @PathVariable BigDecimal quantity) {
   //    Map<String, String> uriVariables = new HashMap<String, String>();
   //    uriVariables.put("from", from);
   //    uriVariables.put("to", to);
   //    ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate()
   //            .getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
   //                    CurrencyConversion.class, uriVariables);
   //    CurrencyConversion conversion = responseEntity.getBody();
   //    return new CurrencyConversion(conversion.getId(), from, to,
   //            conversion.getConversionMultiple(), BigDecimal.valueOf(1000),
   //            quantity.multiply(conversion.getConversionMultiple()), conversion.getPort());
   // }
   //hard-coded conversion value
   // @GetMapping(value = "/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
   // public CurrencyConversion convertCurrency(@PathVariable String from, @PathVariable String to,
   //                                           @PathVariable BigDecimal quantity) {
   //    CurrencyConversion conversion =
   //            new CurrencyConversion(1000L, from, to, BigDecimal.valueOf(65),
   //                    BigDecimal.valueOf(1000), BigDecimal.valueOf(65000), 8100);
   //    return conversion;
   // }
}
