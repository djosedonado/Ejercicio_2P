package com.patrones.ejercicio_2.domains.abstractFactory;

import com.patrones.ejercicio_2.domains.Productos;

import java.util.ArrayList;
import java.util.List;

public class DbMysql implements IproductoDAO{
    private List<Productos> productos = new ArrayList<>();

    @Override
    public Productos create(Productos producto) {
        productos.add(producto);
        return producto;
    }

    @Override
    public Productos read(int id) {
        return productos.stream()
                .filter(producto -> producto.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Productos> readAll() {
        return productos;
    }

    @Override
    public void update(Productos producto) {
        int index = -1;
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getId() == producto.getId()) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            productos.set(index, producto);
            System.out.println("Producto actualizado en MySQL DB.");
        }
    }

    @Override
    public void delete(int id) {
        productos.removeIf(producto -> producto.getId() == id);
        System.out.println("Producto eliminado en MySQL DB.");
    }
}
