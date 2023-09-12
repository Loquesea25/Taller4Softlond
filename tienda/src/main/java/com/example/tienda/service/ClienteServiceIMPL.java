package com.example.tienda.service;

import com.example.tienda.entities.Cliente;
import com.example.tienda.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceIMPL implements IClienteService{
    @Autowired
    private IClienteRepository iClienteRepository;
    @Override
    public List<Cliente> mostrarClientes() {

        return (List<Cliente>) this.iClienteRepository.findAll();
    }

    @Override
    public Cliente crearCliente(Cliente cliente) {
        cliente.setNombreCliente(cliente.getNombreCliente());
        return this.iClienteRepository.save(cliente);
    }

    @Override
    public Cliente modificarCliente(Cliente cliente) {

        return this.iClienteRepository.save(cliente);
    }

    @Override
    public Cliente buscarClientePorId(Long id) {

        return this.iClienteRepository.findById(id).get();
    }

    @Override
    public void eliminarClientePorId(Long id) {

        this.iClienteRepository.deleteById(id);
    }
}
