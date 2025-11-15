package org.sunat.exchange.rate.mapper;


import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.sunat.exchange.rate.model.api.Exchange;
import org.sunat.exchange.rate.model.api.UserDomain;
import org.sunat.exchange.rate.model.entity.Users;

@Mapper(componentModel = "cdi")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "documentNumber", expression = "java(buildDocumentNumber(dni))")
    @Mapping(target = "sunat", expression = "java(exchange.getSunat())")
    @Mapping(target = "buy", expression = "java(exchange.getCompra())")
    @Mapping(target = "sell", expression = "java(exchange.getVenta())")
    //@BeanMapping(builder = @org.mapstruct.Builder(buildMethod = "build"))
    Users toUsers(Exchange exchange, String dni);

    UserDomain toUserDomainBuild(Users users);

    default String buildDocumentNumber(String dni) {
        return dni;
    }
}
