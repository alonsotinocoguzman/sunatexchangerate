package org.sunat.exchange.rate.utils;

public class Constant {

  public static final String QUERY_COUNT =
      "select count(*) from Users s where s.documentNumber = :documentNumber";
  public static final String QUERY_DELETE_DOCUMENT =
      "delete from Users s where s.documentNumber = :documentNumber";
}
