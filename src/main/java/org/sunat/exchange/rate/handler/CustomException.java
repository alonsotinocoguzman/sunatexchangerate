package org.sunat.exchange.rate.handler;

import java.io.Serializable;

public class CustomException extends RuntimeException implements Serializable {
  private static final long serialVersionUID = 1L;

  public CustomException() {}

  public CustomException(String message) {
    super(message);
  }

  public CustomException(String message, Throwable throwable) {
    super(message, throwable);
  }

  public CustomException(Throwable throwable) {
    super(throwable);
  }

  public CustomException(
      String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
