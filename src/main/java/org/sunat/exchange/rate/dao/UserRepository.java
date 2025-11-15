package org.sunat.exchange.rate.dao;

import org.sunat.exchange.rate.model.entity.Users;

public interface UserRepository {
    Long getCountConsulting(String documentNumber);

    Boolean persistenceConsulting(Users users);

    Boolean removeConsulting(String documentNumber);
}
