package com.example.tienda.controller;

import com.example.tienda.entities.Producto;
import com.example.tienda.service.ProductoServiceIMPL;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping(value = "api/producto")
public class ProductoController {
    @Autowired
    private ProductoServiceIMPL productoServiceIMPL;
    @GetMapping
    @RequestMapping(value = "mostrarProductos", method = RequestMethod.GET)
    public ResponseEntity<List> mostrarProductos(){
        Logger logger = LoggerFactory.getLogger(getClass());
        try {
            List<Producto> listaProductos = this.productoServiceIMPL.mostrarProductos();
            return ResponseEntity.ok().body(listaProductos);
        } catch (Exception e) {
            logger.error("Ocurrió un error al mostrar productos.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonList("Ocurrió un error al mostrar productos."));
        }
    }
    @PostMapping
    @RequestMapping(value = "crearProducto", method = RequestMethod.POST)
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto){
        Logger logger = LoggerFactory.getLogger(getClass());
        try{
            Producto productoCreado = this.productoServiceIMPL.crearProducto(producto);
            return ResponseEntity.status(HttpStatus.CREATED).body(productoCreado);
        } catch (Exception e){
            logger.error("Ocurrió un error al crear el producto.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body((Producto) Collections.singletonList("Ocurrió un error al crear el producto."));
        }
    }
    @PutMapping
    @RequestMapping(value = "modificarProducto", method = RequestMethod.PUT)
    public ResponseEntity<Producto> modificarProducto(@RequestBody Producto producto){
        Logger logger = LoggerFactory.getLogger(getClass());
        try{
            Producto productoModficado = this.productoServiceIMPL.modificarProducto(producto);
            return ResponseEntity.status(HttpStatus.CREATED).body(productoModficado);
        }catch (Exception e){
            logger.error("Ocurrió un error al modificar el producto.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body((Producto) Collections.singletonList("Ocurrió un error al modificar el producto."));
        }

    }
    @GetMapping
    @RequestMapping(value = "buscarProductoPorId/{id}", method = RequestMethod.GET)
    public ResponseEntity<Producto> buscarProductoPorId(@PathVariable Long id){
        Logger logger = LoggerFactory.getLogger(getClass());
        try{
            Producto productoBuscado = this.productoServiceIMPL.buscarProductoPorId(id);
            return ResponseEntity.ok().body(productoBuscado);
        }catch (Exception e){
            logger.error("Ocurrió un error al encontrar el producto buscado por id");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body((Producto) Collections.singletonList("Ocurrió un error al encontrar el producto buscado por id."));
        }

    }
    @DeleteMapping
    @RequestMapping(value = "eliminarProductoPorId/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> eliminarProductoPorId(@PathVariable Long id){
        Logger logger = LoggerFactory.getLogger(getClass());
        try{
            this.productoServiceIMPL.eliminarProductoPorId(id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            logger.error("Ocurrió un error al eliminar el producto");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body((Producto) Collections.singletonList("Ocurrió un error al eliminar el producto."));
        }

    }
}
