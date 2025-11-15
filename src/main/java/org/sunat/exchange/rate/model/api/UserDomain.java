package org.sunat.exchange.rate.model.api;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDomain {
  private String documentNumber;
  private String sunat;
  private String buy;
  private String sell;
}
