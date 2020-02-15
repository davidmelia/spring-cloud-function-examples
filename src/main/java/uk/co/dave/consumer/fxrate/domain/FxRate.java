package uk.co.dave.consumer.fxrate.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FxRate implements Serializable {

  private static final long serialVersionUID = -3841396310860569815L;

  private String from;

  private String to;

  private BigDecimal rate;

}
