package xpl.ety;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class ExchangeValue {
   @Getter
   @Setter
   @Id
   private Long id;
   @Getter
   @Setter
   @Column(name = "currency_from")
   private String from;
   @Getter
   @Setter
   @Column(name = "currency_to")
   private String to;
   @Getter
   @Setter
   private BigDecimal conversionMultiple;
   @Setter
   @Getter
   private int port;
}
