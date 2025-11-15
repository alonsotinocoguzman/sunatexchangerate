package org.sunat.exchange.rate.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sunat.exchange.rate.dao.UserRepository;
import org.sunat.exchange.rate.handler.CustomException;
import org.sunat.exchange.rate.mapper.UserMapper;
import org.sunat.exchange.rate.model.api.UserDomain;
import org.sunat.exchange.rate.proxy.ExchangeProxy;
import org.sunat.exchange.rate.service.ExchangeRateService;

@ApplicationScoped
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private static final Logger log = LoggerFactory.getLogger(ExchangeRateServiceImpl.class);
    @Inject
    UserRepository userRepository;

    @Inject
    @RestClient
    ExchangeProxy exchangeProxy;

    @Override
    public UserDomain getExchangeRate(String documentNumber) throws CustomException {

        if (userRepository.getCountConsulting(documentNumber) >= 10) {
            throw new CustomException("You exceeded the number of queries allowed.");
        }
        try {
            var exchange = exchangeProxy.getExchangeRate();
        } catch (CustomException e) {
            log.info("No existe el usuario, se procedera a consultar la api externa");
        }
        var exchange = exchangeProxy.getExchangeRate();
        log.info("reponse api {}", exchange.getCompra().toUpperCase().toString());
        var user = UserMapper.INSTANCE.toUsers(exchange, documentNumber);
        userRepository.persistenceConsulting(user);
        return UserMapper.INSTANCE.toUserDomainBuild(user);
    }

    @Override
    public boolean flushConsulting(String documentNumber) {
        return userRepository.removeConsulting(documentNumber);
    }
}
