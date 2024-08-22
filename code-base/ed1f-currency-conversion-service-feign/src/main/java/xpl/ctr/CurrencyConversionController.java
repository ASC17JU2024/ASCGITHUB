package xpl.ctr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import xpl.mdl.CurrencyConversion;
import xpl.pxy.CurrencyExchangeServiceProxy;

import java.math.BigDecimal;

import static xpl.uty.Colors.*;
 
@RestController
public class CurrencyConversionController {
   @Autowired
   private CurrencyExchangeServiceProxy proxy;

   //using FeignClient & Proxy
   @GetMapping(value = "/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
   public CurrencyConversion convertCurrency(@PathVariable String from, @PathVariable String to,
                                             @PathVariable BigDecimal quantity) {
//      py("feign cleint");
      CurrencyConversion conversion = proxy.retrieveExchangeValue(from, to);
      return new CurrencyConversion(conversion.getId(), from, to,
              conversion.getConversionMultiple(), BigDecimal.valueOf(1000),
              quantity.multiply(conversion.getConversionMultiple()), conversion.getPort());
   }
   //using REST Template : invoking currency exchange service
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
