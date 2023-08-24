package com.example.tienda.service;

import com.example.tienda.entities.Producto;
import com.example.tienda.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceIMPL implements IProductoService{
    @Autowired
    private IProductoRepository iProductoRepository;
    @Override
    public List<Producto> mostrarProductos() {
        return (List<Producto>) this.iProductoRepository.findAll();
    }

    @Override
    public Producto crearProducto(Producto producto) {
        producto.setNombre(producto.getNombre());
        return this.iProductoRepository.save(producto);
    }

    @Override
    public Producto modificarProducto(Producto producto) {
        return this.iProductoRepository.save(producto);
    }

    @Override
    public Producto buscarProductoPorId(Long id) {
        return this.iProductoRepository.findById(id).get();
    }

    @Override
    public void eliminarProductoPorId(Long id) {
        this.iProductoRepository.deleteById(id);
    }
}
