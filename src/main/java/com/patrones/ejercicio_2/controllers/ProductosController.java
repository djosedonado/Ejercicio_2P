package com.patrones.ejercicio_2.controllers;

import com.patrones.ejercicio_2.domains.Productos;
import com.patrones.ejercicio_2.domains.abstractFactory.Config;
import com.patrones.ejercicio_2.domains.abstractFactory.IproductoDAO;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/productos")
public class ProductosController {
    private IproductoDAO productoDAO;

    public ProductosController() {
        Config.configureDb("mysql");
        this.productoDAO = Config.getProductosDAO();
    }

    @PostMapping
    public Productos addProducto(@RequestBody Productos producto) {
        return productoDAO.create(producto);
    }

    @GetMapping
    public List<Productos> getAllProductos() {
        return this.productoDAO.readAll();
    }


    @GetMapping("/{id}")
    public Productos obtenerProducto(@PathVariable int id) {
        return productoDAO.read(id);
    }


    @PutMapping
    public void actualizarProducto(@RequestBody Productos producto) {
        productoDAO.update(producto);
    }

    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable int id) {
        productoDAO.delete(id);
    }
}
