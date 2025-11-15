package org.sunat.exchange.rate.dao.impl;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.sunat.exchange.rate.dao.UserRepository;
import org.sunat.exchange.rate.model.entity.Users;
import org.sunat.exchange.rate.utils.Constant;

@ApplicationScoped
public class UserRepositoryImpl implements PanacheRepository<Users>, UserRepository {

  @Override
  public Long getCountConsulting(String documentNumber) {
    return count(Constant.QUERY_COUNT, Parameters.with("documentNumber", documentNumber));
  }

  @Override
  @Transactional
  public Boolean persistenceConsulting(Users users) {
    persist(users);
    return isPersistent(users);
  }

  @Override
  @Transactional
  public Boolean removeConsulting(String documentNumber) {

    long raw =
        delete(Constant.QUERY_DELETE_DOCUMENT, Parameters.with("documentNumber", documentNumber));

    return raw > 0;
  }
}
