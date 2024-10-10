package com.patrones.ejercicio_2.domains.abstractFactory;

public class Config {
    private static IproductoDAO productoDAO;

    public static void configureDb(String motorDB) {
        switch (motorDB.toLowerCase()) {
            case "mysql":
                productoDAO = new DbMysql();
                break;
            case "oracle":
                productoDAO = new DbOracle();
                break;
            default:
                throw new UnsupportedOperationException("Motor de base de datos no soportado.");
        }
    }

    public static IproductoDAO getProductosDAO() {
        if (productoDAO == null) {
            throw new IllegalStateException("No se ha configurado ningún motor de base de datos.");
        }
        return productoDAO;
    }
}
