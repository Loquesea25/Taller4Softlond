
package com.example.tienda.controller;

import com.example.tienda.entities.Cliente;
import com.example.tienda.service.ClienteServiceIMPL;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "api/cliente")
public class ClienteController {
    @Autowired
    private ClienteServiceIMPL clienteServiceIMPL;
    @GetMapping
    @RequestMapping(value = "mostrarClientes", method = RequestMethod.GET)
    public ResponseEntity<List> mostrarClientes(){
        Logger logger = LoggerFactory.getLogger(getClass());
        try{
            List <Cliente> listaClientes = this.clienteServiceIMPL.mostrarClientes();
            return ResponseEntity.ok().body(listaClientes);
        }catch (Exception e){
            logger.error("Ocurrió un error al mostrar los clientes.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonList("Ocurrió un error al mostrar los clientes."));
        }

    }
    @PostMapping
    @RequestMapping(value = "crearCliente", method = RequestMethod.POST)
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente){
        Logger logger = LoggerFactory.getLogger(getClass());
        try{
            Cliente clienteCreado = this.clienteServiceIMPL.crearCliente(cliente);
            return ResponseEntity.status(HttpStatus.CREATED).body(clienteCreado);
        }catch (Exception e){
            logger.error("Ocurrió un error al crear el cliente.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body((Cliente) Collections.singletonList("Ocurrió un error al crear el cliente."));
        }
    }

    @PutMapping
    @RequestMapping(value = "modificarCliente", method = RequestMethod.PUT)
    public ResponseEntity<Cliente> modificarCliente(@RequestBody Cliente cliente){
        Logger logger = LoggerFactory.getLogger(getClass());
        try{
            Cliente clienteModificado = this.clienteServiceIMPL.modificarCliente(cliente);
            return ResponseEntity.status(HttpStatus.CREATED).body(clienteModificado);
        }catch (Exception e){
            logger.error("Ocurrió un error al modificar el cliente.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body((Cliente) Collections.singletonList("Ocurrió un error al modificar el cliente."));
        }
    }

    @GetMapping
    @RequestMapping(value = "buscarClientePorId/{id}", method = RequestMethod.GET)
    ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long id){
        Logger logger = LoggerFactory.getLogger(getClass());
        try{
            Cliente clienteBuscado = this.clienteServiceIMPL.buscarClientePorId(id);
            return ResponseEntity.ok().body(clienteBuscado);
        }catch (Exception e){
            logger.error("Ocurrió un error al buscar el cliente por ID.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body((Cliente) Collections.singletonList("Ocurrió un error al buscar el cliente por ID."));
        }
    }
    @DeleteMapping
    @RequestMapping(value = "eliminarClientePorId/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Cliente> eliminarClientePorId(@PathVariable Long id){
        Logger logger = LoggerFactory.getLogger(getClass());
        try{
            this.clienteServiceIMPL.eliminarClientePorId(id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            logger.error("Ocurrió un error al eliminar el cliente.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body((Cliente) Collections.singletonList("Ocurrió un error al eliminar el cliente."));
        }
    }
}


