package org.sunat.exchange.rate.service;


import org.sunat.exchange.rate.handler.CustomException;
import org.sunat.exchange.rate.model.api.UserDomain;

public interface ExchangeRateService {
    UserDomain getExchangeRate(String documentNumber) throws CustomException;

    boolean flushConsulting(String documentNumber);
}
