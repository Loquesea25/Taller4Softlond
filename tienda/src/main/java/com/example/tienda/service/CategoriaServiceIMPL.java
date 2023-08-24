package com.example.tienda.service;

import com.example.tienda.entities.Categoria;
import com.example.tienda.repository.ICategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceIMPL implements ICategoriaService{
    @Autowired
    private ICategoriaRepository iCategoriaRepository;
    @Override
    public List<Categoria> mostrarCategorias() {
        return (List<Categoria>) this.iCategoriaRepository.findAll();
    }

    @Override
    public Categoria crearCategoria(Categoria categoria) {
        categoria.setNombreCategoria(categoria.getNombreCategoria());
        return this.iCategoriaRepository.save(categoria);
    }

    @Override
    public Categoria modificarCategoria(Categoria categoria) {
        return this.iCategoriaRepository.save(categoria);
    }

    @Override
    public Categoria buscarCategoriaPorId(Long id) {
        return this.iCategoriaRepository.findById(id).get();
    }

    @Override
    public void eliminarCategoriaPorId(Long id) {
        this.iCategoriaRepository.deleteById(id);
    }
}
