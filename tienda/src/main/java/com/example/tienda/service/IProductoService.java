package com.example.tienda.service;

import com.example.tienda.entities.Producto;

import java.util.List;

public interface IProductoService {
    public List<Producto> mostrarProductos();
    public Producto crearProducto(Producto producto);
    public Producto modificarProducto(Producto producto);
    public Producto buscarProductoPorId(Long id);
    public void eliminarProductoPorId(Long id);
}
