package com.example.tienda.controller;

import com.example.tienda.entities.Categoria;
import com.example.tienda.service.CategoriaServiceIMPL;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "api/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaServiceIMPL categoriaServiceIMPL;
    @GetMapping
    @RequestMapping(value = "mostrarCategorias", method = RequestMethod.GET)
    public ResponseEntity<List> mostrarCategorias(){
        Logger logger = LoggerFactory.getLogger(getClass());
        try{
            List<Categoria> listaCategoria = this.categoriaServiceIMPL.mostrarCategorias();
            return ResponseEntity.ok().body(listaCategoria);
        }catch (Exception e){
            logger.error("Ocurrió un error al mostrar las categorías");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonList("Ocurrió un error al mostrar las categorías."));
        }

    }
    @PostMapping
    @RequestMapping(value = "crearCategoria", method = RequestMethod.POST)
    public ResponseEntity<Categoria> crearCategoria(@RequestBody Categoria categoria){
        Logger logger = LoggerFactory.getLogger(getClass());
        try{
            Categoria categoriaCreada = this.categoriaServiceIMPL.crearCategoria(categoria);
            return ResponseEntity.status(HttpStatus.CREATED).body(categoriaCreada);
        }catch (Exception e){
            logger.error("Ocurrió un error al crear la categoría");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body((Categoria) Collections.singletonList("Ocurrió un error al crear la categoría."));
        }

    }
    @PutMapping
    @RequestMapping(value = "modificarCategoria", method = RequestMethod.PUT)
    public ResponseEntity<Categoria> modificarCategoria(@RequestBody Categoria categoria){
        Logger logger = LoggerFactory.getLogger(getClass());
        try{
            Categoria categoriaModificada = this.categoriaServiceIMPL.modificarCategoria(categoria);
            return ResponseEntity.status(HttpStatus.CREATED).body(categoriaModificada);
        }catch (Exception e){
            logger.error("Ocurrió un error al modificar la categoría");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body((Categoria) Collections.singletonList("Ocurrió un error al modificar la categoría."));
        }

    }
    @GetMapping
    @RequestMapping(value = "buscarCategoriaPorId/{id}", method = RequestMethod.GET)
    public ResponseEntity<Categoria> buscarCategoriaPorId(@PathVariable Long id){
        Logger logger = LoggerFactory.getLogger(getClass());
        try{
            Categoria categoriaBuscada = this.categoriaServiceIMPL.buscarCategoriaPorId(id);
            return ResponseEntity.ok().body(categoriaBuscada);
        }catch (Exception e){
            logger.error("Ocurrió un error al buscar la categoría por id");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body((Categoria) Collections.singletonList("Ocurrió un error al buscar la categoría por id."));
        }

    }
    @DeleteMapping
    @RequestMapping(value = "eliminarCategoriaPorId/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> eliminarCategoriaPorId(@PathVariable Long id){
        Logger logger = LoggerFactory.getLogger(getClass());
        try{
            this.categoriaServiceIMPL.eliminarCategoriaPorId(id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            logger.error("Ocurrió un error al eliminar la categoría");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body((Categoria) Collections.singletonList("Ocurrió un error al eliminar la categoría."));
        }

    }
}
