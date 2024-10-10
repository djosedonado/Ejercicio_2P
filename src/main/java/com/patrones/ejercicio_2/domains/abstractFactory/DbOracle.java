package com.patrones.ejercicio_2.domains.abstractFactory;

import com.patrones.ejercicio_2.domains.Productos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbOracle implements IproductoDAO {

    private Map<Integer, Productos> productos = new HashMap<>();

    @Override
    public Productos create(Productos producto) {
        productos.put(producto.getId(), producto);
        return producto;
    }

    @Override
    public Productos read(int id) {
        return productos.get(id);
    }

    @Override
    public List<Productos> readAll() {
        return new ArrayList<>(productos.values());
    }

    @Override
    public void update(Productos producto) {
        productos.put(producto.getId(),producto);
    }
    @Override
    public void delete(int id) {
        productos.remove(id);
    }
}
