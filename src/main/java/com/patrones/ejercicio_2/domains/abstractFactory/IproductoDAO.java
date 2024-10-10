package com.patrones.ejercicio_2.domains.abstractFactory;


import com.patrones.ejercicio_2.domains.Productos;

import java.util.List;

public interface IproductoDAO {
    Productos create(Productos producto);
    Productos read(int id);
    void update(Productos productos);
    void delete(int id);
    List<Productos> readAll();
}
