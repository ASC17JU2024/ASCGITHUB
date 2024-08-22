package xpl.mdl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConversion {
   @Getter
   @Setter
   private Long id;
   @Getter
   @Setter
   private String from;
   @Getter
   @Setter
   private String to;
   @Getter
   @Setter
   private BigDecimal conversionMultiple;
   @Getter
   @Setter
   private BigDecimal quantity;
   @Getter
   @Setter
   private BigDecimal totalCalculatedAmount;
   @Getter
   @Setter
   private int port;
}
