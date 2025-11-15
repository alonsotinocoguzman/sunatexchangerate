package org.sunat.exchange.rate.handler;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.sunat.exchange.rate.model.api.ErrorMessage;

@Provider
public class CustomerExceptionHandler implements ExceptionMapper<CustomException> {

  @Override
  public Response toResponse(CustomException e) {
    return Response.status(Response.Status.BAD_REQUEST)
        .entity(new ErrorMessage(e.getMessage(), false))
        .build();
  }
}
