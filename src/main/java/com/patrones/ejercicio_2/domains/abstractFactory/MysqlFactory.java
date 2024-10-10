package com.patrones.ejercicio_2.domains.abstractFactory;

public class MysqlFactory extends AbstractFactoryDAO{

    @Override
    public IproductoDAO getIproductoDAO() {
        return new DbMysql();
    }
}
