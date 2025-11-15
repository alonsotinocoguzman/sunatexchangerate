package org.sunat.exchange.rate.model.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Exchange {
  private String fecha;
  private String sunat;
  private String compra;
  private String venta;
}
