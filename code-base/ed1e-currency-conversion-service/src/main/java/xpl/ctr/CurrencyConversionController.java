package xpl.ctr;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import xpl.mdl.CurrencyConversion;
import xpl.uty.Colors;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {
   //invoking currency exchange service
   @GetMapping(value = "/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
   public CurrencyConversion convertCurrency(@PathVariable String from, @PathVariable String to,
                                             @PathVariable BigDecimal quantity) {
      Map<String, String> uriVariables = new HashMap<String, String>();
      uriVariables.put("from", from);
      uriVariables.put("to", to);
      ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate()
              .getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                      CurrencyConversion.class, uriVariables);
      CurrencyConversion conversion = responseEntity.getBody();
      Colors.ppu(conversion);
      return new CurrencyConversion(conversion.getId(), from, to,
              conversion.getConversionMultiple(), BigDecimal.valueOf(1000),
              quantity.multiply(conversion.getConversionMultiple()), conversion.getPort());
   }
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
