package com.patrones.ejercicio_2.domains.abstractFactory;

import org.springframework.boot.autoconfigure.flyway.FlywayProperties;

public class OracleFactory extends AbstractFactoryDAO{
    @Override
    public IproductoDAO getIproductoDAO() {
        return new DbOracle();
    }
}
