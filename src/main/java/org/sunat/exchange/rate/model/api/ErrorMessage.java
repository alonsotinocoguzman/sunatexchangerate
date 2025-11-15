package org.sunat.exchange.rate.model.api;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ErrorMessage {
  private String message;
  private Boolean status;

  public ErrorMessage(String message, Boolean status) {
    super();
    this.message = message;
    this.status = status;
  }

  public ErrorMessage() {
    super();
  }
}
