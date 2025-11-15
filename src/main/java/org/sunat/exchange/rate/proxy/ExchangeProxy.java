package org.sunat.exchange.rate.proxy;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.sunat.exchange.rate.model.api.Exchange;

@RegisterRestClient(baseUri = "https://free.e-api.net.pe")
public interface ExchangeProxy {
  @GET
  @Path("/tipo-cambio/today.json")
  Exchange getExchangeRate();
}
