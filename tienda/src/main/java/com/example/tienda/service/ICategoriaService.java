package com.example.tienda.service;

import com.example.tienda.entities.Categoria;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ICategoriaService {
    public List<Categoria> mostrarCategorias();
    public Categoria crearCategoria(Categoria categoria);
    public Categoria modificarCategoria(Categoria categoria);
    public Categoria buscarCategoriaPorId(Long id);
    public void eliminarCategoriaPorId(Long id);
}
