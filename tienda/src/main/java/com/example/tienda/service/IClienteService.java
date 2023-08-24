package com.example.tienda.service;

import com.example.tienda.entities.Cliente;

import java.util.List;

public interface IClienteService {
    public List<Cliente> mostrarClientes();
    public Cliente crearCliente(Cliente cliente);
    public Cliente modificarCliente(Cliente cliente);
    public Cliente buscarClientePorId(Long id);
    public void eliminarClientePorId(Long id);
}
