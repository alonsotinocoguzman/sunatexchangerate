package org.sunat.exchange.rate.web;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.sunat.exchange.rate.handler.CustomException;
import org.sunat.exchange.rate.service.ExchangeRateService;

@Path("/exchange-rate")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExchangeRateController {

    @Inject
    ExchangeRateService exchangeRateService;

    @GET
    @Path("/consulting/{documentNumber}")
    public Response getExchangeRate(@PathParam("documentNumber") String documentNumber)
            throws CustomException {
        return Response.ok().entity(exchangeRateService.getExchangeRate(documentNumber)).build();
    }

    @DELETE
    @Path("/consulting/{documentNumber}")
    public Response deleteExchangeRate(@PathParam("documentNumber") String documentNumber) {
        return Response.ok().entity(exchangeRateService.flushConsulting(documentNumber)).build();
    }
}
